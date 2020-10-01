import { Component, OnInit } from "@angular/core";
import { YearOfStudy } from "../../../core/models/YearOfStudy";
import { StudentService } from "../../../services/student.service";

@Component({
    selector: "app-student-subjects",
    templateUrl: "./student-subjects.component.html",
    styleUrls: ["./student-subjects.component.scss"],
})
export class StudentSubjectsComponent implements OnInit {
    constructor(private studentService: StudentService) {}

    ngOnInit(): void {
        this.getYearOfStudies();
    }
    yearOfStudies: YearOfStudy[] = [];

    allTotalEspb: number = 0;

    getYearOfStudies(): void {
        this.studentService.getYearOfStudies().subscribe((res) => {
            this.yearOfStudies = res.payload;
            this.yearOfStudies.forEach(
                (e) => (this.allTotalEspb += e.totalEspb)
            );
        });
    }
}
