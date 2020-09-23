import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { UpdatePassword } from "../../../core/requests/UpdatePassword";
import { UserService } from "../../../services/user.service";

@Component({
    selector: "app-user-change-password",
    templateUrl: "./user-change-password.component.html",
    styleUrls: ["./user-change-password.component.scss"],
})
export class UserChangePasswordComponent implements OnInit {
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
