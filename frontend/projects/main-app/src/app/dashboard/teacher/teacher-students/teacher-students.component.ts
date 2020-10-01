import { Component, OnInit } from "@angular/core";
import { Subject } from "rxjs";
import { debounceTime, distinctUntilChanged, switchMap } from "rxjs/operators";
import { userImageURL } from "../../../core/models/API";
import { TeacherStudent } from "../../../core/models/TeacherStudent";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-students",
    templateUrl: "./teacher-students.component.html",
    styleUrls: ["./teacher-students.component.scss"],
})
export class TeacherStudentsComponent implements OnInit {
    constructor(private teacherService: TeacherService) {}

    students: TeacherStudent[] = [];
    currentPage = 0;

    private searchParam = new Subject<string>();

    ngOnInit(): void {
        this.getStudents(this.currentPage);
    }

    readonly studyPrograms$ = this.searchParam.pipe(
        debounceTime(250),
        distinctUntilChanged(),
        switchMap((param) =>
            this.teacherService.searchStudentsByFirstNameOrLastNameOrTranscriptIdentifierOrYearOfEnrollment(
                param
            )
        )
    );
    searchStudents(param: string) {
        if (param != "") {
            this.searchParam.next(param);
            this.studyPrograms$.subscribe((res) => {
                this.students = res.payload["payload"];
            });
        } else {
            this.getStudents(0);
        }
    }

    getStudents(page: number) {
        this.teacherService.getAllStudents(page, 10).subscribe((res) => {
            this.populate(res.payload);
        });
    }

    getStudentImage(image: string) {
        return `${userImageURL}${image}`;
    }

    populate(students: TeacherStudent[]) {
        if (students.length != 0) {
            this.students = students;
        } else {
            this.decreaseCurrentPage();
        }
    }

    increaseCurrentPage() {
        this.currentPage += 1;
    }
    decreaseCurrentPage() {
        if (this.currentPage != 0) {
            this.currentPage -= 1;
        }
    }
}
