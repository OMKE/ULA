import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { SharedModule } from "../../shared/shared.module";
import { AboutHeaderComponent } from "./about-header/about-header.component";
import { AboutNavigationComponent } from "./about-navigation/about-navigation.component";
import { AboutRoutingModule } from "./about-routing.module";
import { AboutUniversityComponent } from "./about-university/about-university.component";
import { AboutComponent } from "./about.component";
import { HistoryUniversityComponent } from "./history-university/history-university.component";
import { PresidentUniversityComponent } from "./president-university/president-university.component";
import { PublishingUniversityComponent } from "./publishing-university/publishing-university.component";
import { TeachingStaffUniversityComponent } from "./teaching-staff-university/teaching-staff-university.component";

@NgModule({
    declarations: [
        AboutComponent,
        AboutUniversityComponent,
        HistoryUniversityComponent,
        PresidentUniversityComponent,
        TeachingStaffUniversityComponent,
        PublishingUniversityComponent,
        AboutNavigationComponent,
        AboutHeaderComponent,
    ],
    imports: [CommonModule, AboutRoutingModule, SharedModule],
})
export class AboutModule {}
