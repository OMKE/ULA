import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { UpdateProfileComponent } from "./update-profile/update-profile.component";
import { UserChangePasswordComponent } from "./user-change-password/user-change-password.component";
import { UserChangeProfileImageComponent } from "./user-change-profile-image/user-change-profile-image.component";
import { UserProfileComponent } from "./user-profile/user-profile.component";
import { UserComponent } from "./user.component";

const routes: Routes = [
    {
        path: "",
        component: UserComponent,
        children: [
            {
                path: "",
                component: UserProfileComponent,
            },
            {
                path: "update-profile",
                component: UpdateProfileComponent,
            },
            {
                path: "change-password",
                component: UserChangePasswordComponent,
            },
            {
                path: "profile-image",
                component: UserChangeProfileImageComponent,
            },
        ],
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class UserRoutingModule {}
