import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { TeacherExam } from "../../../core/models/TeacherExam";
import { UpdateStudentExamRequest } from "../../../core/requests/UpdateStudentExamRequest";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-exam-update",
    templateUrl: "./teacher-exam-update.component.html",
    styleUrls: ["./teacher-exam-update.component.scss"],
})
export class TeacherExamUpdateComponent implements OnInit {
    constructor(
        private teacherService: TeacherService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit(): void {
        this.getExam();
    }

    request: UpdateStudentExamRequest = {
        points: null,
        description: "",
    };

    exam: TeacherExam = {
        id: null,
        examType: "",
        takingExamId: null,
        examTypeId: null,
        points: null,
        examEntry: {
            id: null,
            examTerm: null,
            examTermId: null,
            active: null,
            examId: null,
        },
        startTime: null,
        endTime: null,
        finalExam: null,
    };

    getExam(): void {
        this.teacherService
            .getOneStudentExam(
                this.route.snapshot.params["id"],
                this.route.snapshot.params["studentId"],
                this.route.snapshot.params["examId"]
            )
            .subscribe((res) => {
                this.exam = res.payload;
            });
    }

    errors: string[] = [];
    updateExam(): void {
        this.teacherService
            .updateStudentExam(
                this.route.snapshot.params["id"],
                this.route.snapshot.params["studentId"],
                this.route.snapshot.params["examId"],
                this.request
            )
            .subscribe((res) => {
                if (res.errors != undefined) {
                    this.errors = res.errors;
                } else {
                    this.router.navigate([
                        `/dashboard/teacher/subjects/${this.route.snapshot.params["id"]}/student/${this.route.snapshot.params["studentId"]}`,
                    ]);
                }
            });
    }
}
