import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { StudentSubject } from "../../../core/models/StudentSubject";
import { TakingExam } from "../../../core/models/TakingExam";
import { ExamEntryRequest } from "../../../core/requests/ExamEntryRequest";
import { StudentService } from "../../../services/student.service";

@Component({
    selector: "app-student-subject",
    templateUrl: "./student-subject.component.html",
    styleUrls: ["./student-subject.component.scss"],
})
export class StudentSubjectComponent implements OnInit {
    constructor(
        private studentService: StudentService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    subject: StudentSubject = {
        id: null,
        studentId: null,
        subject: {
            id: null,
            yearOfStudyId: null,
            subjectRealizationId: null,
            name: "",
            semester: null,
            espb: null,
            required: null,
            numberOfLectures: null,
            numberOfPracticalLectures: null,
            otherFormsOfLectures: null,
            researchWorks: null,
            otherLectures: null,
        },
    };
    takingExam: TakingExam = {
        id: null,
        subjectAttendanceId: null,
        points: null,
        note: "",
        exams: [
            {
                id: null,
                examEntry: {
                    id: null,
                    examType: "",
                    active: null,
                },
                startTime: null,
                endTime: null,
                points: null,
                examType: "",
                finalExam: null,
            },
        ],
    };

    examEntryRequest: ExamEntryRequest = {
        active: true,
    };

    ngOnInit(): void {
        this.getOneSubject();
    }
    errors: string[] = [];

    getOneSubject(): void {
        this.studentService
            .getOneSubject(this.route.snapshot.params["id"])
            .subscribe((res) => {
                this.subject = res.payload;
                this.getTakingExam();
            });
    }

    getTakingExam(): void {
        this.studentService.getTakingExam(this.subject.id).subscribe((res) => {
            this.takingExam = res.payload;
        });
    }

    addExamEntry(examId: number): void {
        this.studentService
            .addExamEntry(this.subject.id, examId, this.examEntryRequest)
            .subscribe((res) => {
                const payload = res.payload
                    .replace("\\", "")
                    .replace('"', "")
                    .replace('"', "");
                if (
                    payload ==
                    "Exam entry has not been placed because it passed more than 10 days before the exam"
                ) {
                    this.errors = [];
                    this.errors.push(payload);
                } else {
                    this.getTakingExam();
                }
            });
    }
}
