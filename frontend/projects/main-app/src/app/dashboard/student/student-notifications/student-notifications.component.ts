import { Component, Input, OnInit } from "@angular/core";
import { StudentService } from "../../../services/student.service";

@Component({
    selector: "app-student-notifications",
    templateUrl: "./student-notifications.component.html",
    styleUrls: ["./student-notifications.component.scss"],
})
export class StudentNotificationsComponent implements OnInit {
    constructor(private studentService: StudentService) {}

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
        if (!this.basedOnSubject) {
            this.studentService
                .getNotifications(page, 7)
                .subscribe((res) => this.populate(res.payload));
        } else {
            this.studentService
                .getBasedOnSubject(this.subjectId, page, 7)
                .subscribe((res) => {
                    this.populate(res.payload);
                });
        }
    }

    populate(notifications: Notification[]) {
        if (notifications.length != 0) {
            this.notifications = notifications;
        } else {
            this.decreaseCurrentPage();
        }
    }
}
