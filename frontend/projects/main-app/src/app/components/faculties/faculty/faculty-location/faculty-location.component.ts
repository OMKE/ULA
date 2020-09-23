import { AfterViewInit, Component } from "@angular/core";
import { Router } from "@angular/router";
import * as L from "leaflet";
import { Faculty } from "projects/main-app/src/app/core/models/Faculty";
import { FacultyService } from "projects/main-app/src/app/services/faculty.service";
@Component({
    selector: "app-faculty-location",
    templateUrl: "./faculty-location.component.html",
    styleUrls: ["./faculty-location.component.scss"],
})
export class FacultyLocationComponent implements AfterViewInit {
    constructor(
        private facultyService: FacultyService,
        private router: Router
    ) {}

    faculty: Faculty = {
        id: null,
        name: "",
        campusId: null,
        icon: "",
        contact: {
            phoneNumber: "",
            email: "",
        },
        location: {
            id: null,
            longitude: null,
            latitude: null,
            name: "",
        },
        information: {
            facultyId: null,
            history: "",
            president: "",
            mission: "",
            accreditation: "",
        },
    };

    latitude: number = null;
    longitude: number = null;

    ngAfterViewInit(): void {
        this.getLocation();
    }

    getLocation() {
        const url = this.router.url.split("/")[2];
        this.facultyService.getFaculty(url).subscribe((response) => {
            this.faculty = response.payload;
            this.latitude = this.faculty.location.latitude;
            this.longitude = this.faculty.location.longitude;
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
            .setContent(this.faculty.location.name)
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
