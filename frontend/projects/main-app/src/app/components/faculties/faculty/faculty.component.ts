import { Component, OnInit, ViewChild } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Faculty } from "../../../core/models/Faculty";
import { StudyProgram } from "../../../core/models/StudyProgram";
import { FacultyService } from "../../../services/faculty.service";
import { FacultyStudiesComponent } from "./faculty-studies/faculty-studies.component";

@Component({
    selector: "app-faculty",
    templateUrl: "./faculty.component.html",
    styleUrls: ["./faculty.component.scss"],
})
export class FacultyComponent implements OnInit {
    @ViewChild(FacultyStudiesComponent) studiesReference;

    constructor(
        private route: ActivatedRoute,
        private facultyService: FacultyService
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

    studyPrograms: StudyProgram[];

    // Will come from store
    heading: string = "Faculty of Technical Sciences";

    ngOnInit(): void {
        this.getFaculty();
    }

    getFaculty(): void {
        this.facultyService
            .getFaculty(this.route.snapshot.params["name"])
            .subscribe((response) => {
                this.faculty = response.payload;
                this.heading = this.faculty.name;
            });
    }
}
