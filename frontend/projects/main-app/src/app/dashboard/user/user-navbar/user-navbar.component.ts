import { Component, OnInit } from "@angular/core";
import { AuthService } from "../../../services/auth.service";

@Component({
    selector: "app-user-navbar",
    templateUrl: "./user-navbar.component.html",
    styleUrls: ["./user-navbar.component.scss"],
})
export class UserNavbarComponent implements OnInit {
    constructor(public authService: AuthService) {}

    ngOnInit(): void {}
    dropDown = false;
    navbar: boolean = false;
}
