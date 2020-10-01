import { Component, OnInit } from "@angular/core";
import { StudentSubject } from "../../../core/models/StudentSubject";
import { StudentService } from "../../../services/student.service";

@Component({
    selector: "app-student-history",
    templateUrl: "./student-history.component.html",
    styleUrls: ["./student-history.component.scss"],
})
export class StudentHistoryComponent implements OnInit {
    constructor(private studentService: StudentService) {}

    passedSubjects: StudentSubject[] = [];

    notPassedSubjects: StudentSubject[] = [];

    ngOnInit(): void {
        this.getAllNotPassedSubjects();
        this.getAllPassedSubjects();
    }

    getAllPassedSubjects(): void {
        this.studentService.getAllPassedSubjects().subscribe((res) => {
            this.passedSubjects = res.payload;
        });
    }

    getAllNotPassedSubjects(): void {
        this.studentService.getAllNotPassedSubjects().subscribe((res) => {
            this.notPassedSubjects = res.payload;
        });
    }
}
