import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Address } from "projects/main-app/src/app/core/models/Address";
import { FacultyService } from "projects/main-app/src/app/services/faculty.service";

@Component({
    selector: "app-faculty-contact",
    templateUrl: "./faculty-contact.component.html",
    styleUrls: ["./faculty-contact.component.scss"],
})
export class FacultyContactComponent implements OnInit {
    constructor(
        private router: Router,
        private facultyService: FacultyService
    ) {}

    // Store
    name: string = "";

    facultySlug: string = "";

    // Should get from faculty info
    address: Address = {
        id: null,
        cityName: "",
        streetName: "",
        number: "",
        postalCode: "",
    };
    email: string = "";

    phoneNumber: string = "";

    getPhoneNumber(): string {
        const pN = this.phoneNumber.split("-");
        return `(${pN[0]})-${pN[1]}-${pN[2]}`;
    }

    ngOnInit(): void {
        const url = this.router.url.split("")[2];
        this.getFaculty();
    }

    getFaculty(): void {
        const slug = this.router.url.split("/")[2];
        this.facultyService.getFaculty(slug).subscribe((response) => {
            const faculty = response.payload;
            this.name = faculty.name;
            this.address = faculty.contact.address;
            this.phoneNumber = faculty.contact.phoneNumber;
            this.email = faculty.contact.email;
        });
    }
}
