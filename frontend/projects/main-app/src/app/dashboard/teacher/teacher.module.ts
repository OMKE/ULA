import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { SharedModule } from "../../shared/shared.module";
import { TeacherComponent } from "../teacher/teacher.component";
import { TeacherAddTeachingTermComponent } from "./teacher-add-teaching-term/teacher-add-teaching-term.component";
import { TeacherChangePasswordComponent } from "./teacher-change-password/teacher-change-password.component";
import { TeacherChangeProfileImageComponent } from "./teacher-change-profile-image/teacher-change-profile-image.component";
import { TeacherExamAddComponent } from "./teacher-exam-add/teacher-exam-add.component";
import { TeacherExamUpdateComponent } from "./teacher-exam-update/teacher-exam-update.component";
import { TeacherExamComponent } from "./teacher-exam/teacher-exam.component";
import { TeacherNavbarComponent } from "./teacher-navbar/teacher-navbar.component";
import { TeacherNotificationsAddComponent } from "./teacher-notifications-add/teacher-notifications-add.component";
import { TeacherNotificationsComponent } from "./teacher-notifications/teacher-notifications.component";
import { TeacherProfileComponent } from "./teacher-profile/teacher-profile.component";
import { TeacherRoutingModule } from "./teacher-routing.module";
import { TeacherStudentComponent } from "./teacher-student/teacher-student.component";
import { TeacherStudentsComponent } from "./teacher-students/teacher-students.component";
import { TeacherSubjectStudentComponent } from "./teacher-subject-student/teacher-subject-student.component";
import { TeacherSubjectComponent } from "./teacher-subject/teacher-subject.component";
import { TeacherSubjectsComponent } from "./teacher-subjects/teacher-subjects.component";
import { TeacherUpdateProfileComponent } from "./teacher-update-profile/teacher-update-profile.component";
import { TeacherUpdateSubjectSyllabusComponent } from "./teacher-update-subject-syllabus/teacher-update-subject-syllabus.component";

@NgModule({
    declarations: [
        TeacherComponent,
        TeacherProfileComponent,
        TeacherUpdateProfileComponent,
        TeacherChangePasswordComponent,
        TeacherChangeProfileImageComponent,
        TeacherNotificationsComponent,
        TeacherStudentsComponent,
        TeacherSubjectsComponent,
        TeacherUpdateSubjectSyllabusComponent,
        TeacherAddTeachingTermComponent,
        TeacherExamComponent,
        TeacherExamUpdateComponent,
        TeacherExamAddComponent,
        TeacherNavbarComponent,
        TeacherNotificationsAddComponent,
        TeacherStudentComponent,
        TeacherSubjectComponent,
        TeacherSubjectStudentComponent,
    ],
    imports: [CommonModule, TeacherRoutingModule, FormsModule, SharedModule],
})
export class TeacherModule {}
