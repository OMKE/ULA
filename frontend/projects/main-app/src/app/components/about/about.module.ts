import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AboutRoutingModule } from './about-routing.module';
import { AboutUniversityComponent } from './about-university/about-university.component';
import { HistoryUniversityComponent } from './history-university/history-university.component';
import { PresidentUniversityComponent } from './president-university/president-university.component';
import { TeachingStaffUniversityComponent } from './teaching-staff-university/teaching-staff-university.component';
import { PublishingUniversityComponent } from './publishing-university/publishing-university.component';


@NgModule({
  declarations: [AboutUniversityComponent, HistoryUniversityComponent, PresidentUniversityComponent, TeachingStaffUniversityComponent, PublishingUniversityComponent],
  imports: [
    CommonModule,
    AboutRoutingModule
  ]
})
export class AboutModule { }
