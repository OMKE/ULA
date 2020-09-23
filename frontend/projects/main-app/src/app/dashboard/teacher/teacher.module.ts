import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { TeacherComponent } from "../teacher/teacher.component";
import { TeacherRoutingModule } from "./teacher-routing.module";

@NgModule({
    declarations: [TeacherComponent],
    imports: [CommonModule, TeacherRoutingModule],
})
export class TeacherModule {}
