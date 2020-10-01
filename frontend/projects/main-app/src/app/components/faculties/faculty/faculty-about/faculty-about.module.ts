import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { SharedModule } from "projects/main-app/src/app/shared/shared.module";
import { FacultyAboutNavigationComponent } from "./faculty-about-navigation/faculty-about-navigation.component";
import { FacultyAboutRoutingModule } from "./faculty-about-routing.module";
import { FacultyAboutComponent } from "./faculty-about.component";
import { FacultyAccreditationComponent } from "./faculty-accreditation/faculty-accreditation.component";
import { FacultyHistoryComponent } from "./faculty-history/faculty-history.component";
import { FacultyMissionComponent } from "./faculty-mission/faculty-mission.component";
import { FacultyPresidentComponent } from "./faculty-president/faculty-president.component";

@NgModule({
    declarations: [
        FacultyHistoryComponent,
        FacultyMissionComponent,
        FacultyPresidentComponent,
        FacultyAccreditationComponent,
        FacultyAboutNavigationComponent,
        FacultyAboutComponent,
    ],
    imports: [CommonModule, FacultyAboutRoutingModule, SharedModule],
    exports: [],
})
export class FacultyAboutModule {}
