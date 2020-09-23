import { Component, OnInit } from "@angular/core";
import { AuthService } from "../../../services/auth.service";

@Component({
    selector: "app-student-navbar",
    templateUrl: "./student-navbar.component.html",
    styleUrls: ["./student-navbar.component.scss"],
})
export class StudentNavbarComponent implements OnInit {
    constructor(public authService: AuthService) {}

    ngOnInit(): void {}

    dropDown: boolean = false;
    navbar: boolean = false;

    public navbarCollapsed = true;
}
