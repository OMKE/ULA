import { Component, OnInit } from "@angular/core";
import { AuthService } from "../../../services/auth.service";

@Component({
    selector: "app-admin-navbar",
    templateUrl: "./admin-navbar.component.html",
    styleUrls: ["./admin-navbar.component.scss"],
})
export class AdminNavbarComponent implements OnInit {
    constructor(public authService: AuthService) {}

    ngOnInit(): void {}

    dropDown: boolean = false;
    navbar: boolean = false;

    public navbarCollapsed = true;
}
