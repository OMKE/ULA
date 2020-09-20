import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { FacultyAboutComponent } from "./faculty-about.component";
import { FacultyAccreditationComponent } from "./faculty-accreditation/faculty-accreditation.component";
import { FacultyHistoryComponent } from "./faculty-history/faculty-history.component";
import { FacultyMissionComponent } from "./faculty-mission/faculty-mission.component";
import { FacultyPresidentComponent } from "./faculty-president/faculty-president.component";

const routes: Routes = [
    {
        path: "",
        component: FacultyAboutComponent,
        children: [
            {
                path: "",
                component: FacultyHistoryComponent,
            },
            {
                path: "president",
                component: FacultyPresidentComponent,
            },
            {
                path: "mission",
                component: FacultyMissionComponent,
            },
            {
                path: "accreditation",
                component: FacultyAccreditationComponent,
            },
        ],
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class FacultyAboutRoutingModule {}
