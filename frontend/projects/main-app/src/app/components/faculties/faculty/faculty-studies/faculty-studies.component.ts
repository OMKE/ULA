import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Faculty } from "projects/main-app/src/app/core/models/Faculty";
import { StudyProgram } from "projects/main-app/src/app/core/models/StudyProgram";
import { FacultyService } from "projects/main-app/src/app/services/faculty.service";

@Component({
    selector: "app-faculty-studies",
    templateUrl: "./faculty-studies.component.html",
    styleUrls: ["./faculty-studies.component.scss"],
})
export class FacultyStudiesComponent implements OnInit {
    constructor(
        private router: Router,
        private facultyService: FacultyService
    ) {}

    name: string = "";

    faculty: Faculty = {
        id: null,
        icon: "",
        name: "",
    };

    studyPrograms: StudyProgram[];

    getFaculty(): void {
        this.facultyService.getFaculty(this.name).subscribe((response) => {
            this.faculty = response.payload;
            this.name = this.faculty.name;
        });
    }

    ngOnInit(): void {
        this.name = this.router.url.split("/")[2];
        this.getFaculty();
    }

    propagateStudyPrograms(studyPrograms: StudyProgram[]) {
        this.studyPrograms = studyPrograms;
    }
}
