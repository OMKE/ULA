import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { SharedModule } from "../../shared/shared.module";
import { FacultiesRoutingModule } from "./faculties-routing.module";
import { FacultiesComponent } from "./faculties.component";
import { FacultyListItemComponent } from "./faculty-list/faculty-list-item/faculty-list-item.component";
import { FacultyListComponent } from "./faculty-list/faculty-list.component";

@NgModule({
    declarations: [
        FacultiesComponent,
        FacultyListComponent,
        FacultyListItemComponent,
    ],
    imports: [CommonModule, FacultiesRoutingModule, SharedModule],
})
export class FacultiesModule {}
