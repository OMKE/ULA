import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { imageAssetURL } from "../../../core/models/API";
import { Faculty } from "../../../core/models/Faculty";
import { FacultyService } from "../../../services/faculty.service";

@Component({
    selector: "app-faculty-list",
    templateUrl: "./faculty-list.component.html",
    styleUrls: ["./faculty-list.component.scss"],
})
export class FacultyListComponent implements OnInit {
    constructor(
        private facultyService: FacultyService,
        private router: Router
    ) {}

    faculties: Faculty[];

    ngOnInit(): void {
        this.facultyService
            .getFaculties()
            .subscribe(
                (response) =>
                    (this.faculties = this.prependUrl(response.payload))
            );
    }

    prependUrl(faculties: Faculty[]): Faculty[] {
        return faculties.map((item) => {
            item.icon = `${imageAssetURL}/${item.icon}`;
            return item;
        });
    }

    getLink(name: string) {
        return name.replace(/\s+/g, "");
    }
}
