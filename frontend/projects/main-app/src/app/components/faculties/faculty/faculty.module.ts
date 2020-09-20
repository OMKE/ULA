import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { SharedModule } from "../../../shared/shared.module";
import { FacultyContactComponent } from "./faculty-contact/faculty-contact.component";
import { FacultyListItemComponent } from "./faculty-list-item/faculty-list-item.component";
import { FacultyListComponent } from "./faculty-list/faculty-list.component";
import { FacultyLocationComponent } from "./faculty-location/faculty-location.component";
import { FacultyNavbarComponent } from "./faculty-navbar/faculty-navbar.component";
import { FacultyRoutingModule } from "./faculty-routing.module";
import { FacultyStudiesComponent } from "./faculty-studies/faculty-studies.component";
import { FacultyComponent } from "./faculty.component";

@NgModule({
    declarations: [
        FacultyComponent,
        FacultyNavbarComponent,
        FacultyStudiesComponent,
        FacultyLocationComponent,
        FacultyContactComponent,
        FacultyListComponent,
        FacultyListItemComponent,
    ],
    imports: [CommonModule, FacultyRoutingModule, SharedModule],
    exports: [],
})
export class FacultyModule {}
