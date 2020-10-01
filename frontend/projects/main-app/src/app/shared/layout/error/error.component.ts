import { Component, Input, OnInit } from "@angular/core";
import { ErrorService } from "../../../services/error.service";

@Component({
    selector: "app-error",
    templateUrl: "./error.component.html",
    styleUrls: ["./error.component.scss"],
})
export class ErrorComponent implements OnInit {
    constructor(private errorService: ErrorService) {}

    @Input()
    errors: string[];

    ngOnInit(): void {}
}
