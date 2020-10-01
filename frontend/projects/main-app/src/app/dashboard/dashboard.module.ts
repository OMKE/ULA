import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { DashboardComponent } from "../dashboard/dashboard.component";
import { SharedModule } from "../shared/shared.module";
import { AdminModule } from "./admin/admin.module";
import { DashboardRoutingModule } from "./dashboard-routing.module";
import { StudentModule } from "./student/student.module";
import { TeacherModule } from "./teacher/teacher.module";
import { UserModule } from "./user/user.module";

@NgModule({
    declarations: [DashboardComponent],
    imports: [
        CommonModule,
        DashboardRoutingModule,
        SharedModule,
        FormsModule,
        StudentModule,
        TeacherModule,
        AdminModule,
        UserModule,
        SharedModule,
    ],
})
export class DashboardModule {}
