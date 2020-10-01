import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { SharedModule } from "../../shared/shared.module";
import { StudentComponent } from "../student/student.component";
import { StudentChangePasswordComponent } from "./student-change-password/student-change-password.component";
import { StudentChangeProfileImageComponent } from "./student-change-profile-image/student-change-profile-image.component";
import { StudentHistoryComponent } from "./student-history/student-history.component";
import { StudentNavbarComponent } from "./student-navbar/student-navbar.component";
import { StudentNotificationsComponent } from "./student-notifications/student-notifications.component";
import { StudentProfileComponent } from "./student-profile/student-profile.component";
import { StudentRoutingModule } from "./student-routing.module";
import { StudentSubjectComponent } from "./student-subject/student-subject.component";
import { StudentSubjectsComponent } from "./student-subjects/student-subjects.component";
import { StudentUpdateProfileComponent } from "./student-update-profile/student-update-profile.component";

@NgModule({
    declarations: [
        StudentComponent,
        StudentNavbarComponent,
        StudentProfileComponent,
        StudentUpdateProfileComponent,
        StudentChangeProfileImageComponent,
        StudentChangePasswordComponent,
        StudentSubjectsComponent,
        StudentNotificationsComponent,
        StudentHistoryComponent,
        StudentSubjectComponent,
    ],
    imports: [CommonModule, StudentRoutingModule, FormsModule, SharedModule],
})
export class StudentModule {}
