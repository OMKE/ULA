import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { userImageURL } from "../../../core/models/API";
import { Subject } from "../../../core/models/Subject";
import { TeacherStudent } from "../../../core/models/TeacherStudent";
import { TeachingTerm } from "../../../core/models/TeachingTerm";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-subject",
    templateUrl: "./teacher-subject.component.html",
    styleUrls: ["./teacher-subject.component.scss"],
    encapsulation: ViewEncapsulation.None,
})
export class TeacherSubjectComponent implements OnInit {
    constructor(
        private teacherService: TeacherService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    students: TeacherStudent[];

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

    teachingTerms: TeachingTerm[];

    currentPageStudent: number = 0;

    currentPageTeachingTerms: number = 0;

    ngOnInit(): void {
        this.getSubject();
        this.getStudents(this.currentPageStudent);
        this.getTeachingTerms(this.currentPageTeachingTerms);
    }

    getSubject() {
        this.teacherService
            .getOneSubject(this.route.snapshot.params["id"])
            .subscribe((res) => (this.subject = res.payload));
    }

    getTeachingTerms(page: number) {
        this.teacherService
            .getTeachingTerm(this.route.snapshot.params["id"], page, 7)
            .subscribe((res) => {
                this.populateTeachingTerms(res.payload);
            });
    }

    getStudents(page: number) {
        this.teacherService
            .getStudentsBySubject(this.route.snapshot.params["id"], page, 10)
            .subscribe((res) => {
                this.populateStudents(res.payload);
            });
    }

    getStudentImage(image: string) {
        return `${userImageURL}${image}`;
    }

    populateStudents(students: TeacherStudent[]) {
        if (students.length != 0) {
            this.students = students;
        } else {
            this.decreaseStudentCurrentPage();
        }
    }

    populateTeachingTerms(teachingTerms: TeachingTerm[]) {
        if (teachingTerms.length != 0) {
            this.teachingTerms = teachingTerms;
        } else {
            this.decreaseTermsCurrentPage();
        }
    }

    increaseStudentCurrentPage() {
        this.currentPageStudent += 1;
    }
    decreaseStudentCurrentPage() {
        if (this.currentPageStudent != 0) {
            this.currentPageStudent -= 1;
        }
    }

    increaseTermsCurrentPage() {
        this.currentPageTeachingTerms += 1;
    }
    decreaseTermsCurrentPage() {
        if (this.currentPageTeachingTerms != 0) {
            this.currentPageTeachingTerms -= 1;
        }
    }

    navigateToTeachingTermAdd(): void {
        this.router.navigate([
            `/dashboard/teacher/subjects/${this.subject.id}/add-teaching-term`,
        ]);
    }

    navigateToAddExam(): void {
        this.router.navigate([
            `/dashboard/teacher/subjects/${this.subject.id}/add-exam`,
        ]);
    }
}
