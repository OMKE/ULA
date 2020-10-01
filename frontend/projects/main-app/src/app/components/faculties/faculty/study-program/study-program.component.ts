import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { StudyProgram } from "projects/main-app/src/app/core/models/StudyProgram";
import { Subject } from "projects/main-app/src/app/core/models/Subject";
import { YearOfStudy } from "projects/main-app/src/app/core/models/YearOfStudy";
import { FacultyService } from "projects/main-app/src/app/services/faculty.service";

@Component({
    selector: "app-study-program",
    templateUrl: "./study-program.component.html",
    styleUrls: ["./study-program.component.scss"],
})
export class StudyProgramComponent implements OnInit {
    constructor(
        private facultyService: FacultyService,
        private route: ActivatedRoute
    ) {}

    studyProgram: StudyProgram = {
        id: null,
        facultyId: null,
        name: "",
        description: "",
        location: {
            name: "",
        },
        degree: {
            level: "",
        },
        manager: {
            id: null,
            studyProgramId: null,
            firstName: "",
            lastName: "",
            title: "",
            phoneNumber: "",
            email: "",
        },
    };

    yearOfStudies: YearOfStudy[];

    subjects: Subject[];

    currentYear: YearOfStudy = null;

    isActive(id: number) {
        if (this.currentYear != null) {
            return this.currentYear.id == id;
        }
    }

    ngOnInit(): void {
        this.facultyService
            .getStudyProgram(this.route.snapshot.params["id"])
            .subscribe((res) => {
                this.studyProgram = res.payload;
                this.facultyService
                    .getYearsOfStudy(this.studyProgram.id)
                    .subscribe((res) => {
                        this.yearOfStudies = res.payload;
                        if (this.yearOfStudies.length != 0) {
                            this.facultyService
                                .getSubjects(this.yearOfStudies[0].id)
                                .subscribe((res) => {
                                    this.subjects = res.payload;
                                    this.currentYear = this.yearOfStudies[0];
                                });
                        }
                    });
            });
    }

    showYearOfStudy(id: number) {
        this.facultyService.getSubjects(id).subscribe((res) => {
            this.subjects = res.payload;

            this.currentYear = this.yearOfStudies.find((year) => year.id == id);
        });
    }
}
