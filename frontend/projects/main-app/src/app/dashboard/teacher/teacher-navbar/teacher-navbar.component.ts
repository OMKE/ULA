import { Component, OnInit } from "@angular/core";
import { AuthService } from "../../../services/auth.service";

@Component({
    selector: "app-teacher-navbar",
    templateUrl: "./teacher-navbar.component.html",
    styleUrls: ["./teacher-navbar.component.scss"],
})
export class TeacherNavbarComponent implements OnInit {
    constructor(public authService: AuthService) {}

    ngOnInit(): void {}

    dropDown: boolean = false;
    navbar: boolean = false;

    public navbarCollapsed = true;
}
