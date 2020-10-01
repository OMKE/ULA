import { Component, OnInit } from "@angular/core";
import { userImageURL } from "../../../core/models/API";
import { User } from "../../../core/models/User";
import { UserService } from "../../../services/user.service";

@Component({
    selector: "app-student-profile",
    templateUrl: "./student-profile.component.html",
    styleUrls: ["./student-profile.component.scss"],
})
export class StudentProfileComponent implements OnInit {
    constructor(private userService: UserService) {}

    ngOnInit(): void {
        this.getUserData();
    }

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

    imageUrlPrefix = `${userImageURL}`;

    getUserData() {
        this.userService.getUserData().subscribe((res) => {
            this.user = res.payload;
        });
    }
    getImage() {
        return `${this.imageUrlPrefix}${this.user.profileImage}`;
    }
}
