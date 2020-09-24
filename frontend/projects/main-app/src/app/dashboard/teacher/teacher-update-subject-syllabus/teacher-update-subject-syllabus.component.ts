import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Subject } from "../../../core/models/Subject";
import { UpdateSubjectSyllabusRequest } from "../../../core/requests/UpdateSubjectSyllabusRequest";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-update-subject-syllabus",
    templateUrl: "./teacher-update-subject-syllabus.component.html",
    styleUrls: ["./teacher-update-subject-syllabus.component.scss"],
})
export class TeacherUpdateSubjectSyllabusComponent implements OnInit {
    constructor(
        private teacherService: TeacherService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    quillStyles = {
        height: "30rem",
    };

    config = {
        toolbar: [["bold", "italic"], [{ header: [1, 2, 3, 5, 6, false] }]],
    };

    content: string = "";

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

    request: UpdateSubjectSyllabusRequest = {
        content: "",
    };

    ngOnInit(): void {
        this.teacherService
            .getOneSubject(this.route.snapshot.params["id"])
            .subscribe((res) => {
                this.subject = res.payload;
                this.content = res.payload.syllabus.content;
            });
    }

    updateSyllabus(): void {
        this.request.content = this.content;
        this.teacherService
            .updateSubjectSyllabus(this.subject.id, this.request)
            .subscribe((res) => {
                this.router.navigate([
                    `/dashboard/teacher/subjects/${this.subject.id}`,
                ]);
            });
    }
}
