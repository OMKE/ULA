import { Component, Input, OnInit } from "@angular/core";

@Component({
  selector: "app-big-heading",
  templateUrl: "./big-heading.component.html",
  styleUrls: ["./big-heading.component.scss"],
})
export class BigHeadingComponent implements OnInit {
  @Input() text: string;

  constructor() {}

  ngOnInit(): void {}
}
