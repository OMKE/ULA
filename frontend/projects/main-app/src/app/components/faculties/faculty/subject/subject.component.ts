import { Component, Input, OnInit, ViewEncapsulation } from "@angular/core";
import { Subject } from "projects/main-app/src/app/core/models/Subject";
import { TeachingMaterial } from "projects/main-app/src/app/core/models/TeachingMaterial";
import { FacultyService } from "projects/main-app/src/app/services/faculty.service";

@Component({
    selector: "app-subject",
    templateUrl: "./subject.component.html",
    styleUrls: ["./subject.component.scss"],
    encapsulation: ViewEncapsulation.None,
})
export class SubjectComponent implements OnInit {
    constructor(private facultyService: FacultyService) {}

    @Input() subject: Subject = {
        id: null,
        yearOfStudyId: null,
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

    teachingMaterial: TeachingMaterial[] = [];

    isTeachingMaterialShowed: boolean = false;

    hasTeachingMaterial: boolean = false;

    getTeachingMaterial(subjectId: number): void {
        this.facultyService.getTeachingMaterial(subjectId).subscribe((res) => {
            this.teachingMaterial = res.payload;
            this.show();
            this.teachingMaterial.length == 0
                ? (this.hasTeachingMaterial = false)
                : (this.hasTeachingMaterial = true);
        });
    }

    show() {
        this.isTeachingMaterialShowed = !this.isTeachingMaterialShowed;
    }

    ngOnInit(): void {}
}
