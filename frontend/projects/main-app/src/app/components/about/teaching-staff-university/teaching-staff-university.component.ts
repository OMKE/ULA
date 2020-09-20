import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { TeachingStaff } from "../../../core/models/UniversityInformation";
import { UniversityService } from "../../../services/university.service";

@Component({
    selector: "app-teaching-staff-university",
    templateUrl: "./teaching-staff-university.component.html",
    styleUrls: ["./teaching-staff-university.component.scss"],
    encapsulation: ViewEncapsulation.None,
})
export class TeachingStaffUniversityComponent implements OnInit {
    constructor(private universityService: UniversityService) {}

    content: TeachingStaff;

    res: string;

    ngOnInit(): void {
        this.universityService.getAbout().subscribe((e) => {
            this.content = e.payload;
        });
    }
}
