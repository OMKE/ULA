import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { History } from "../../../core/models/UniversityInformation";
import { UniversityService } from "../../../services/university.service";

@Component({
    selector: "app-history-university",
    templateUrl: "./history-university.component.html",
    styleUrls: ["./history-university.component.scss"],
    encapsulation: ViewEncapsulation.None,
})
export class HistoryUniversityComponent implements OnInit {
    constructor(private universityService: UniversityService) {}

    content: History;

    res: string;

    ngOnInit(): void {
        this.universityService.getAbout().subscribe((e) => {
            this.content = e.payload;
        });
    }
}
