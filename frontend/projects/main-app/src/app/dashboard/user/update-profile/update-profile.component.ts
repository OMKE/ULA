import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { User } from "../../../core/models/User";
import { UpdateFirstNameLastName } from "../../../core/requests/UpdateFirstNameLastName";
import { UserService } from "../../../services/user.service";

@Component({
    selector: "app-update-profile",
    templateUrl: "./update-profile.component.html",
    styleUrls: ["./update-profile.component.scss"],
})
export class UpdateProfileComponent implements OnInit {
    constructor(private userService: UserService, private router: Router) {}

    user: User = {
        id: null,
        username: "",
        email: "",
        profileImage: "",
        firstName: "",
        lastName: "",
        password: null,
        roles: [],
    };

    updateRequest: UpdateFirstNameLastName = {
        firstName: "",
        lastName: "",
    };

    getUserData() {
        this.userService.getUserData().subscribe((res) => {
            this.user = res.payload;
            this.updateRequest.firstName = this.user.firstName;
            this.updateRequest.lastName = this.user.lastName;
        });
    }

    errors: string[];

    ngOnInit(): void {
        this.getUserData();
    }

    update() {
        this.userService.updateUserData(this.updateRequest).subscribe((res) => {
            if (res.errors != undefined) {
                this.errors = res.errors;
            } else {
                this.router.navigate(["/dashboard/user"]);
            }
        });
    }
}
