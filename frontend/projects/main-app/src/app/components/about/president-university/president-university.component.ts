import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { President } from "../../../core/models/UniversityInformation";
import { UniversityService } from "../../../services/university.service";

@Component({
    selector: "app-president-university",
    templateUrl: "./president-university.component.html",
    styleUrls: ["./president-university.component.scss"],
    encapsulation: ViewEncapsulation.None,
})
export class PresidentUniversityComponent implements OnInit {
    constructor(private universityService: UniversityService) {}

    content: President;

    res: string;

    ngOnInit(): void {
        this.universityService.getAbout().subscribe((e) => {
            this.content = e.payload;
        });
    }
}
