import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { User } from "../../core/models/User";
import { AuthService } from "../../services/auth.service";

@Component({
    selector: "app-login",
    templateUrl: "./login.component.html",
    styleUrls: ["./login.component.scss"],
})
export class LoginComponent implements OnInit {
    constructor(private authService: AuthService, private router: Router) {}

    user: User = {
        username: "",
        password: "",
        roles: [],
    };

    ngOnInit(): void {}

    errors: string[];

    login() {
        this.authService.login(this.user).subscribe((response) => {
            if (response.errors != undefined) {
                this.errors = response.errors;
            } else {
                this.authService.setToken(response.payload);
                this.router.navigate(["/dashboard/user"]);
            }
        });
    }
}
