import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { TeachingType } from "../../../core/models/TeachingType";
import { AddTeachingTermRequest } from "../../../core/requests/AddTeachingTermRequest";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-add-teaching-term",
    templateUrl: "./teacher-add-teaching-term.component.html",
    styleUrls: ["./teacher-add-teaching-term.component.scss"],
})
export class TeacherAddTeachingTermComponent implements OnInit {
    constructor(
        private teacherService: TeacherService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    teachingTypes: TeachingType[] = [];

    ngOnInit(): void {
        this.teacherService
            .getTeachingTermTypes()
            .subscribe((res) => (this.teachingTypes = res.payload));
    }

    request: AddTeachingTermRequest = {
        subjectId: this.route.snapshot.params["id"],
        typeId: null,
        startTime: null,
        endTime: null,
        teachingMaterialName: "",
        authors: [
            {
                firstName: "",
                lastName: "",
            },
        ],
        teachingMaterialPublicationDate: null,
        teachingTermOutcomeDescription: "",
    };

    errors: string[] = [];

    add(): void {
        this.teacherService.addTeachingTerm(this.request).subscribe((res) => {
            if (res.errors != undefined) {
                this.errors = res.errors;
            } else {
                this.router.navigate([
                    `/dashboard/teacher/subjects/${this.request.subjectId}`,
                ]);
            }
        });
    }
}
