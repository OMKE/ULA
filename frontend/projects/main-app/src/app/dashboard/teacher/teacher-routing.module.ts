import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { TeacherChangePasswordComponent } from "./teacher-change-password/teacher-change-password.component";
import { TeacherChangeProfileImageComponent } from "./teacher-change-profile-image/teacher-change-profile-image.component";
import { TeacherNotificationsAddComponent } from "./teacher-notifications-add/teacher-notifications-add.component";
import { TeacherNotificationsComponent } from "./teacher-notifications/teacher-notifications.component";
import { TeacherProfileComponent } from "./teacher-profile/teacher-profile.component";
import { TeacherStudentComponent } from "./teacher-student/teacher-student.component";
import { TeacherStudentsComponent } from "./teacher-students/teacher-students.component";
import { TeacherSubjectComponent } from "./teacher-subject/teacher-subject.component";
import { TeacherSubjectsComponent } from "./teacher-subjects/teacher-subjects.component";
import { TeacherTeachingTermsComponent } from "./teacher-teaching-terms/teacher-teaching-terms.component";
import { TeacherUpdateProfileComponent } from "./teacher-update-profile/teacher-update-profile.component";
import { TeacherComponent } from "./teacher.component";

const routes: Routes = [
    {
        path: "",
        component: TeacherComponent,
        children: [
            {
                path: "",
                component: TeacherProfileComponent,
            },
            {
                path: "update-profile",
                component: TeacherUpdateProfileComponent,
            },
            {
                path: "change-password",
                component: TeacherChangePasswordComponent,
            },
            {
                path: "profile-image",
                component: TeacherChangeProfileImageComponent,
            },
            {
                path: "subjects",
                component: TeacherSubjectsComponent,
            },
            {
                path: "subjects/:id",
                component: TeacherSubjectComponent,
            },
            {
                path: "teaching-terms",
                component: TeacherTeachingTermsComponent,
            },
            {
                path: "students",
                component: TeacherStudentsComponent,
            },
            {
                path: "students/:id",
                component: TeacherStudentComponent,
            },
            {
                path: "notifications",
                component: TeacherNotificationsComponent,
            },
            {
                path: "notifications/add",
                component: TeacherNotificationsAddComponent,
            },
        ],
    },
    {
        path: "**",
        component: TeacherProfileComponent,
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class TeacherRoutingModule {}
