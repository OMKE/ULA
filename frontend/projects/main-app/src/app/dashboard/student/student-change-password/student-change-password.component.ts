import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { UpdatePassword } from "../../../core/requests/UpdatePassword";
import { UserService } from "../../../services/user.service";

@Component({
    selector: "app-student-change-password",
    templateUrl: "./student-change-password.component.html",
    styleUrls: ["./student-change-password.component.scss"],
})
export class StudentChangePasswordComponent implements OnInit {
    constructor(private userService: UserService, private router: Router) {}

    request: UpdatePassword = {
        oldPassword: "",
        password: "",
        confirmPassword: "",
    };

    ngOnInit(): void {}

    errors: string[];

    changePassword() {
        this.userService.updateUserPassword(this.request).subscribe((res) => {
            if (res.errors != undefined) {
                this.errors = res.errors;
            } else {
                this.router.navigate(["/dashboard/user"]);
                console.log("aa");
            }
        });
    }
}
