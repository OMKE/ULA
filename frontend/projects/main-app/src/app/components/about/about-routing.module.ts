import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AboutUniversityComponent } from "./about-university/about-university.component";
import { AboutComponent } from "./about.component";
import { HistoryUniversityComponent } from "./history-university/history-university.component";
import { PresidentUniversityComponent } from "./president-university/president-university.component";
import { PublishingUniversityComponent } from "./publishing-university/publishing-university.component";
import { TeachingStaffUniversityComponent } from "./teaching-staff-university/teaching-staff-university.component";

const routes: Routes = [
  {
    path: "",
    component: AboutComponent,
    children: [
      {
        path: "",
        component: AboutUniversityComponent,
      },
      {
        path: "history",
        component: HistoryUniversityComponent,
        data: {
          title: "ULA - University History",
        },
      },
      {
        path: "president",
        component: PresidentUniversityComponent,
        data: {
          title: "ULA - University President",
        },
      },
      {
        path: "teachingStaff",
        component: TeachingStaffUniversityComponent,
        data: {
          title: "ULA - University Teaching Staff",
        },
      },
      {
        path: "publishing",
        component: PublishingUniversityComponent,
        data: {
          title: "ULA - University Publishing",
        },
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AboutRoutingModule {}
