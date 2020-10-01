import { Component, OnInit } from "@angular/core";
import { Subject } from "../../../core/models/Subject";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-subjects",
    templateUrl: "./teacher-subjects.component.html",
    styleUrls: ["./teacher-subjects.component.scss"],
})
export class TeacherSubjectsComponent implements OnInit {
    constructor(private teacherService: TeacherService) {}

    subjects: Subject[];

    ngOnInit(): void {
        this.getSubjects();
    }

    getSubjects() {
        this.teacherService
            .getAllSubjects()
            .subscribe((res) => (this.subjects = res.payload));
    }
}
