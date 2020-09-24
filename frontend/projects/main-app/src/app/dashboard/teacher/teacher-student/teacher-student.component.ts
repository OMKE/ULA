import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { userImageURL } from "../../../core/models/API";
import { TeacherStudent } from "../../../core/models/TeacherStudent";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-student",
    templateUrl: "./teacher-student.component.html",
    styleUrls: ["./teacher-student.component.scss"],
})
export class TeacherStudentComponent implements OnInit {
    constructor(
        private teacherService: TeacherService,
        private route: ActivatedRoute
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

    ngOnInit(): void {
        this.getStudent();
    }

    imageUrlPrefix = `${userImageURL}`;

    getImage() {
        return `${this.imageUrlPrefix}${this.student.student.user.profileImage}`;
    }

    getStudent() {
        this.teacherService
            .getOneStudent(this.route.snapshot.params["id"])
            .subscribe((res) => {
                this.student = res.payload;
            });
    }
}
