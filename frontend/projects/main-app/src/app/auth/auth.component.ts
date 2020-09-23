import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: "app-auth",
    templateUrl: "./auth.component.html",
    styleUrls: ["./auth.component.scss"],
})
export class AuthComponent implements OnInit {
    constructor(private router: Router) {}

    ngOnInit(): void {
        if (
            this.router.url.split("/")[1] == "auth" &&
            this.router.url.split("/").length == 2
        ) {
            this.router.navigate(["auth/login"]);
        }
    }
}
