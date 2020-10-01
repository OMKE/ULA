import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { ExamTerm } from "../../../core/models/ExamTerm";
import { ExamType } from "../../../core/models/ExamType";
import { AddExamRequest } from "../../../core/requests/AddExamRequest";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-exam-add",
    templateUrl: "./teacher-exam-add.component.html",
    styleUrls: ["./teacher-exam-add.component.scss"],
})
export class TeacherExamAddComponent implements OnInit {
    constructor(
        private teacherService: TeacherService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    examTerms: ExamTerm[];

    examTypes: ExamType[];

    ngOnInit(): void {
        this.getExamTerms();
        this.getExamTypes();
    }

    exam: AddExamRequest = {
        typeId: null,
        examTermId: null,
        startTime: null,
        endTime: null,
        finalExam: null,
    };

    errors: string[] = [];

    getExamTerms() {
        this.teacherService
            .getExamTerms()
            .subscribe((res) => (this.examTerms = res.payload));
    }

    getExamTypes() {
        this.teacherService
            .getExamTypes()
            .subscribe((res) => (this.examTypes = res.payload));
    }

    addExam() {
        this.teacherService
            .addExam(this.route.snapshot.params["id"], this.exam)
            .subscribe((res) => {
                if (res.errors != undefined) {
                    this.errors = res.errors;
                } else {
                    this.router.navigate([
                        `/dashboard/teacher/subjects/${this.route.snapshot.params["id"]}`,
                    ]);
                }
            });
    }
}
