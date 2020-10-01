import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AdminGuard } from "../guards/admin.guard";
import { StudentGuard } from "../guards/student.guard";
import { TeacherGuard } from "../guards/teacher.guard";
import { UserGuard } from "../guards/user.guard";
import { DashboardComponent } from "./dashboard.component";

const routes: Routes = [
    {
        path: "",
        redirectTo: "",
        pathMatch: "full",
        component: DashboardComponent,
    },
    {
        path: "user",
        loadChildren: () =>
            import("./user/user.module").then((m) => m.UserModule),
        canActivate: [UserGuard],
    },
    {
        path: "student",
        loadChildren: () =>
            import("./student/student.module").then((m) => m.StudentModule),
        canActivate: [StudentGuard],
    },
    {
        path: "admin",
        loadChildren: () =>
            import("./admin/admin.module").then((m) => m.AdminModule),
        canActivate: [AdminGuard],
    },
    {
        path: "teacher",
        loadChildren: () =>
            import("./teacher/teacher.module").then((m) => m.TeacherModule),
        canActivate: [TeacherGuard],
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class DashboardRoutingModule {}
