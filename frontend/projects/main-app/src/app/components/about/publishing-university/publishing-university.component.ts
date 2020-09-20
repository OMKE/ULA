import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { Publishing } from "../../../core/models/UniversityInformation";
import { UniversityService } from "../../../services/university.service";

@Component({
    selector: "app-publishing-university",
    templateUrl: "./publishing-university.component.html",
    styleUrls: ["./publishing-university.component.scss"],
    encapsulation: ViewEncapsulation.None,
})
export class PublishingUniversityComponent implements OnInit {
    constructor(private universityService: UniversityService) {}

    content: Publishing;

    res: string;

    ngOnInit(): void {
        this.universityService.getAbout().subscribe((e) => {
            this.content = e.payload;
        });
    }
}
