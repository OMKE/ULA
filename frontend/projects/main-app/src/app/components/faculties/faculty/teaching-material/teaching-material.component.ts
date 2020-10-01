import { Component, Input, OnInit } from "@angular/core";
import { TeachingMaterial } from "projects/main-app/src/app/core/models/TeachingMaterial";

@Component({
    selector: "app-teaching-material",
    templateUrl: "./teaching-material.component.html",
    styleUrls: ["./teaching-material.component.scss"],
})
export class TeachingMaterialComponent implements OnInit {
    constructor() {}

    @Input() teachingMaterial: TeachingMaterial = {
        id: null,
        teachingTermId: null,
        name: "",
        publicationDate: null,
        authors: null,
    };

    ngOnInit(): void {}
}
