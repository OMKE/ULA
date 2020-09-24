import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Subject } from "../../../core/models/Subject";
import { SubjectNotificationType } from "../../../core/models/SubjectNotificationType";
import { AddNotificationRequest } from "../../../core/requests/AddNotificationRequest";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-notifications-add",
    templateUrl: "./teacher-notifications-add.component.html",
    styleUrls: ["./teacher-notifications-add.component.scss"],
})
export class TeacherNotificationsAddComponent implements OnInit {
    constructor(
        private teacherService: TeacherService,
        private router: Router
    ) {}

    notificationTypes: SubjectNotificationType[];

    subjects: Subject[];

    notification: AddNotificationRequest = {
        subjectId: null,
        typeId: null,
        text: "",
    };

    errors: string[] = [];

    ngOnInit(): void {
        this.teacherService
            .getNotificationTypes()
            .subscribe((res) => (this.notificationTypes = res.payload));

        this.teacherService
            .getAllSubjects()
            .subscribe((res) => (this.subjects = res.payload));
    }

    addNotification() {
        this.teacherService
            .addNotification(this.notification)
            .subscribe((res) => {
                if (res.errors != undefined) {
                    this.errors = res.errors;
                } else {
                    this.router.navigate(["/dashboard/teacher/notifications"]);
                }
            });
    }
}
