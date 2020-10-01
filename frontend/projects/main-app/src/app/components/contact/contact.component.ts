import { AfterViewInit, Component } from "@angular/core";
import * as L from "leaflet";
import { Contact } from "../../core/models/UniversityInformation";
import { UniversityService } from "../../services/university.service";

@Component({
    selector: "app-contact",
    templateUrl: "./contact.component.html",
    styleUrls: ["./contact.component.scss"],
})
export class ContactComponent implements AfterViewInit {
    constructor(private universityService: UniversityService) {}

    contact: Contact = {
        phoneNumbers: [
            {
                id: null,
                contactInfo: "",
                number: "",
            },
        ],
        addresses: [
            {
                id: null,
                cityName: "",
                streetName: "",
                number: "",
                postalCode: "",
            },
        ],
        location: {
            id: null,
            longitude: null,
            latitude: null,
            name: "",
        },
    };

    latitude: number = null;
    longitude: number = null;

    ngAfterViewInit(): void {
        this.getContact();
    }

    getContact() {
        this.universityService.getContact().subscribe((res) => {
            this.contact = res.payload;
            this.latitude = this.contact.location.latitude;
            this.longitude = this.contact.location.longitude;
            this.initMap();
        });
    }

    private map;

    private initMap(): void {
        this.map = L.map("map", {
            center: [this.latitude, this.longitude],
            zoom: 17,
        });
        const popup = L.popup()
            .setLatLng([this.latitude, this.longitude])
            .setContent(this.contact.location.name)
            .openOn(this.map);

        const tiles = L.tileLayer(
            "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
            {
                maxZoom: 19,
            }
        );

        tiles.addTo(this.map);
    }
}
