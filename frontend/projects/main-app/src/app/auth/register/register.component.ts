import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { User } from "../../core/models/User";
import { AuthService } from "../../services/auth.service";

@Component({
    selector: "app-register",
    templateUrl: "./register.component.html",
    styleUrls: ["./register.component.scss"],
})
export class RegisterComponent implements OnInit {
    constructor(private authService: AuthService, private router: Router) {}

    user: User = {
        username: "",
        password: "",
        confirmPassword: "",
        firstName: "",
        lastName: "",
        email: "",
        acceptTerms: null,
        roles: [],
    };

    ngOnInit(): void {}

    errors: string[] = [];

    register() {
        this.authService.register(this.user).subscribe((response) => {
            if (response.errors == undefined) {
                this.router.navigate(["auth/login"]);
            } else {
                this.errors = response.errors;
            }
        });
    }
}
