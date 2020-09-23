import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { SharedModule } from "../../shared/shared.module";
import { UserComponent } from "../user/user.component";
import { UpdateProfileComponent } from "./update-profile/update-profile.component";
import { UserChangePasswordComponent } from "./user-change-password/user-change-password.component";
import { UserNavbarComponent } from "./user-navbar/user-navbar.component";
import { UserProfileComponent } from "./user-profile/user-profile.component";
import { UserRoutingModule } from "./user-routing.module";
import { UserChangeProfileImageComponent } from './user-change-profile-image/user-change-profile-image.component';

@NgModule({
    declarations: [
        UserComponent,
        UserNavbarComponent,
        UpdateProfileComponent,
        UserProfileComponent,
        UserChangePasswordComponent,
        UserChangeProfileImageComponent,
    ],
    imports: [CommonModule, UserRoutingModule, SharedModule, FormsModule],
})
export class UserModule {}
