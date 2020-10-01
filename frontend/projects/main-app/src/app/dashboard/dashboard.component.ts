import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../services/auth.service";

@Component({
    selector: "app-dashboard",
    templateUrl: "./dashboard.component.html",
    styleUrls: ["./dashboard.component.scss"],
    encapsulation: ViewEncapsulation.None,
})
export class DashboardComponent implements OnInit {
    constructor(private authService: AuthService, private router: Router) {}

    ngOnInit(): void {
        if (this.authService.isAdmin()) {
            this.router.navigate(["dashboard/admin"]);
        } else if (this.authService.isStudent()) {
            this.router.navigate(["dashboard/student"]);
        } else if (this.authService.isTeacher()) {
            this.router.navigate(["dashboard/teacher"]);
        } else if (this.authService.isUser()) {
            this.router.navigate(["dashboard/user"]);
        } else {
            this.router.navigate(["auth/login"]);
        }
    }
}
