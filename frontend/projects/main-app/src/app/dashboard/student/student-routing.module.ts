import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { StudentChangePasswordComponent } from "./student-change-password/student-change-password.component";
import { StudentChangeProfileImageComponent } from "./student-change-profile-image/student-change-profile-image.component";
import { StudentHistoryComponent } from "./student-history/student-history.component";
import { StudentNotificationsComponent } from "./student-notifications/student-notifications.component";
import { StudentProfileComponent } from "./student-profile/student-profile.component";
import { StudentSubjectComponent } from "./student-subject/student-subject.component";
import { StudentSubjectsComponent } from "./student-subjects/student-subjects.component";
import { StudentUpdateProfileComponent } from "./student-update-profile/student-update-profile.component";
import { StudentComponent } from "./student.component";

const routes: Routes = [
    {
        path: "",
        component: StudentComponent,
        children: [
            {
                path: "",
                component: StudentProfileComponent,
            },
            {
                path: "update-profile",
                component: StudentUpdateProfileComponent,
            },
            {
                path: "change-password",
                component: StudentChangePasswordComponent,
            },
            {
                path: "profile-image",
                component: StudentChangeProfileImageComponent,
            },
            {
                path: "subjects",
                component: StudentSubjectsComponent,
            },
            {
                path: "subjects/:id",
                component: StudentSubjectComponent,
            },
            {
                path: "notifications",
                component: StudentNotificationsComponent,
            },
            {
                path: "history",
                component: StudentHistoryComponent,
            },
        ],
    },
    {
        path: "**",
        component: StudentProfileComponent,
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class StudentRoutingModule {}
