import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Faculty } from "projects/main-app/src/app/core/models/Faculty";
import { StudyProgram } from "projects/main-app/src/app/core/models/StudyProgram";
import { FacultyService } from "projects/main-app/src/app/services/faculty.service";

@Component({
    selector: "app-faculty-list",
    templateUrl: "./faculty-list.component.html",
    styleUrls: ["./faculty-list.component.scss"],
})
export class FacultyListComponent implements OnInit {
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

    totalPages: number = null;

    getFaculty(): void {
        this.name = this.router.url.split("/")[2];
        this.facultyService.getFaculty(this.name).subscribe((response) => {
            this.faculty = response.payload;
            this.getStudyPrograms(this.faculty.id, 7, 0);
        });
    }

    getStudyPrograms(facultyId: number, size: number, page: number): void {
        this.facultyService
            .getStudyPrograms(facultyId, size, page)
            .subscribe((response) => {
                this.studyPrograms = response.payload.studyPrograms;
                this.totalPages = response.payload.totalPages;
            });
    }

    ngOnInit(): void {
        this.getFaculty();
    }
}
