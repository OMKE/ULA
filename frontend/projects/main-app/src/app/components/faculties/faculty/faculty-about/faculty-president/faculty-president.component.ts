import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { Router } from "@angular/router";
import { Faculty } from "projects/main-app/src/app/core/models/Faculty";
import { FacultyService } from "projects/main-app/src/app/services/faculty.service";

@Component({
    selector: "app-faculty-president",
    templateUrl: "./faculty-president.component.html",
    styleUrls: ["./faculty-president.component.scss"],
    encapsulation: ViewEncapsulation.None,
})
export class FacultyPresidentComponent implements OnInit {
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

    content: string = "";

    ngOnInit(): void {
        const url = this.router.url.split("/")[2];
        this.facultyService.getFaculty(url).subscribe((response) => {
            this.faculty = response.payload;
            this.content = this.faculty.information.president;
        });
    }
}
