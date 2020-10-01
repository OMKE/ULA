import { Component, Input, OnInit } from "@angular/core";
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

    @Input()
    studyPrograms: StudyProgram[];

    currentPage: number = 0;

    totalPages: number = null;

    pages: number[] = [];

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
                this.paginate();
            });
    }

    paginate() {
        for (let i = 0; i <= this.totalPages; i++) {
            this.pages.push(i + 1);
        }
    }

    ngOnInit(): void {
        this.getFaculty();
    }

    isActivePage(page) {
        return this.currentPage == page - 1;
    }

    showStudyProgramsByPage(page: number, event: any): void {
        this.pages = [];
        this.getStudyPrograms(this.faculty.id, 7, page - 1);
        this.currentPage = page - 1;
    }
}
