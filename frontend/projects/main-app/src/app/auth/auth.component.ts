import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../services/auth.service";

@Component({
    selector: "app-auth",
    templateUrl: "./auth.component.html",
    styleUrls: ["./auth.component.scss"],
})
export class AuthComponent implements OnInit {
    constructor(private router: Router, private authService: AuthService) {}

    ngOnInit(): void {
        if (
            this.router.url.split("/")[1] == "auth" &&
            this.router.url.split("/").length == 2
        ) {
            if (this.authService.getUser()) {
                this.router.navigate(["dashboard/user"]);
            } else {
                this.router.navigate(["auth/login"]);
            }
        }
    }
}
