import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { userImageURL } from "../../../core/models/API";
import { StudentPointsCalculated } from "../../../core/models/StudentPointsCalculated";
import { Subject } from "../../../core/models/Subject";
import { TakingExam } from "../../../core/models/TakingExam";
import { TeacherStudent } from "../../../core/models/TeacherStudent";
import { UpdateFinalGradeRequest } from "../../../core/requests/UpdateFinalGradeRequest";
import { UpdateStudentPointsRequest } from "../../../core/requests/UpdateStudentPointsRequest";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-subject-student",
    templateUrl: "./teacher-subject-student.component.html",
    styleUrls: ["./teacher-subject-student.component.scss"],
})
export class TeacherSubjectStudentComponent implements OnInit {
    constructor(
        private teacherService: TeacherService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    student: TeacherStudent = {
        id: null,
        student: {
            id: null,
            user: {
                id: null,
                username: null,
                email: null,
                profileImage: "",
                firstName: "",
                lastName: "",
            },
            phoneNumber: "",
            dateOfBirth: null,
        },
        yearOfStudyIds: [],
        dateOfEnrollment: null,
        transcriptIdentifier: "",
        attendance: {
            id: null,
            studentId: null,
            subjectRealizationId: null,
            finalGrade: null,
        },
    };

    allTakingExam: TakingExam = {
        id: null,
        subjectAttendanceId: null,
        points: null,
        note: "",
        exams: [
            {
                id: null,
                examType: "",
                startTime: null,
                endTime: null,
                points: null,
                finalExam: null,
                examEntry: {
                    id: null,
                    examType: "",
                    active: null,
                },
            },
        ],
    };

    calculatedTakingExam: StudentPointsCalculated = {
        takingExamId: null,
        subjectAttendanceId: null,
        points: null,
        subject: "",
        hasFinal: null,
        exams: [
            {
                id: null,
                examType: "",
                startTime: null,
                endTime: null,
                points: null,
                finalExam: null,
                examEntry: {
                    id: null,
                    examType: "",
                    active: null,
                },
                outcome: {
                    id: null,
                    examId: null,
                    description: "",
                },
            },
        ],
    };

    subject: Subject = {
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
        syllabus: {
            id: null,
            subjectId: null,
            content: "",
        },
    };

    ngOnInit(): void {
        this.getSubject();
        this.getStudent();
        this.getStudentsExams();
        this.getStudentExamsCalculated();
    }

    imageUrlPrefix = `${userImageURL}`;

    getImage() {
        return `${this.imageUrlPrefix}${this.student.student.user.profileImage}`;
    }

    getSubject() {
        this.teacherService
            .getOneSubject(this.route.snapshot.params["id"])
            .subscribe((res) => (this.subject = res.payload));
    }

    getStudent(): void {
        this.teacherService
            .getOneStudentBySubject(
                this.route.snapshot.params["id"],
                this.route.snapshot.params["studentId"]
            )
            .subscribe((res) => {
                this.student = res.payload;
            });
    }

    getStudentsExams(): void {
        this.teacherService
            .getAllStudentExam(
                this.route.snapshot.params["id"],
                this.route.snapshot.params["studentId"]
            )
            .subscribe((res) => (this.allTakingExam = res.payload));
    }

    getStudentExamsCalculated(): void {
        this.teacherService
            .getStudentPointsCalculated(
                this.route.snapshot.params["id"],
                this.route.snapshot.params["studentId"]
            )
            .subscribe((res) => {
                this.calculatedTakingExam = res.payload["payload"];
            });
    }

    errors: string[] = [];

    updateTakingExamPoints(): void {
        const request: UpdateStudentPointsRequest = {
            points: this.calculatedTakingExam.points,
        };
        this.teacherService
            .updateStudentPoints(
                this.route.snapshot.params["id"],
                this.route.snapshot.params["studentId"],
                request
            )
            .subscribe((res) => {
                if (res.errors != undefined) {
                    this.errors = res.errors;
                } else {
                    this.getStudentsExams();
                }
            });
    }

    updateFinalGradeRequest: UpdateFinalGradeRequest = {
        finalGrade: null,
    };

    textSuccess: string = "";
    updateFinalGrade(): void {
        this.teacherService
            .updateFinalGrade(
                this.subject.id,
                this.student.id,
                this.updateFinalGradeRequest
            )
            .subscribe((res) => {
                if (res.errors != undefined) {
                    this.errors = res.errors;
                } else {
                    this.textSuccess = res.payload;
                    setTimeout(() => {
                        this.textSuccess = "";
                    }, 2000);
                    this.getStudent();
                }
            });
    }

    navigateToUpdateExam(examId): void {
        this.router.navigate([
            `/dashboard/teacher/subjects/${this.subject.id}/student/${this.student.id}/update-exam/${examId}`,
        ]);
    }
}
