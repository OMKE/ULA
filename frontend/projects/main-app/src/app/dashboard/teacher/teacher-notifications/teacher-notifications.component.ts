import { Component, Input, OnInit } from "@angular/core";
import { TeacherService } from "../../../services/teacher.service";

@Component({
    selector: "app-teacher-notifications",
    templateUrl: "./teacher-notifications.component.html",
    styleUrls: ["./teacher-notifications.component.scss"],
})
export class TeacherNotificationsComponent implements OnInit {
    constructor(private teacherService: TeacherService) {}

    notifications: Notification[] = [];

    currentPage = 0;

    @Input()
    basedOnSubject: boolean = false;

    @Input()
    subjectId: number = null;

    ngOnInit(): void {
        this.getNotifications(this.currentPage);
    }
    increaseCurrentPage() {
        this.currentPage += 1;
    }
    decreaseCurrentPage() {
        if (this.currentPage != 0) {
            this.currentPage -= 1;
        }
    }

    getNotifications(page: number): void {
        this.teacherService.getNotifications(page, 12).subscribe((res) => {
            this.populate(res.payload);
        });
    }

    populate(notifications: Notification[]) {
        if (notifications.length != 0) {
            this.notifications = notifications;
        } else {
            this.decreaseCurrentPage();
        }
    }
}
