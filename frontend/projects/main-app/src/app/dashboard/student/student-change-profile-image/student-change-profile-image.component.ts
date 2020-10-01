import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { userImageURL } from "../../../core/models/API";
import { User } from "../../../core/models/User";
import { UserService } from "../../../services/user.service";

class Image {
    constructor(public src: string, public file: File) {}
}

@Component({
    selector: "app-student-change-profile-image",
    templateUrl: "./student-change-profile-image.component.html",
    styleUrls: ["./student-change-profile-image.component.scss"],
})
export class StudentChangeProfileImageComponent implements OnInit {
    constructor(private userService: UserService, private router: Router) {}

    ngOnInit(): void {
        this.getUserData();
    }

    selectedImage: Image;

    processFile(imageInput: any) {
        const file: File = imageInput.files[0];
        const reader = new FileReader();

        reader.addEventListener("load", (event: any) => {
            this.selectedImage = new Image(event.target.result, file);

            this.userService.addImage(this.selectedImage.file).subscribe(
                (res) => {
                    console.log(res.payload);
                    this.router.navigate(["/dashboard/user"]);
                },
                (err) => {
                    console.log(err);
                }
            );
        });

        reader.readAsDataURL(file);
    }

    deleteImage() {
        this.userService.deleteImage().subscribe((res) => {
            this.router.navigate(["/dashboard/user/profile-image"]);
            this.user.profileImage = `users/user-icon.png`;
        });
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
