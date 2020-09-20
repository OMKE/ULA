import { Component, Input, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: "app-faculty-list-item",
    templateUrl: "./faculty-list-item.component.html",
    styleUrls: ["./faculty-list-item.component.scss"],
})
export class FacultyListItemComponent implements OnInit {
    constructor(private router: Router) {}

    @Input() text: string;

    @Input() imagePath: string;

    ngOnInit(): void {}
}
