import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { Information } from "../../../core/models/UniversityInformation";
import { UniversityService } from "../../../services/university.service";

@Component({
    selector: "app-about-university",
    templateUrl: "./about-university.component.html",
    styleUrls: ["./about-university.component.scss"],
    encapsulation: ViewEncapsulation.None,
})
export class AboutUniversityComponent implements OnInit {
    constructor(private universityService: UniversityService) {}

    content: Information;

    res: string;

    ngOnInit(): void {
        this.universityService.getAbout().subscribe((e) => {
            this.content = e.payload;
        });
    }
}
