import { Component, Input, OnInit } from "@angular/core";

@Component({
  selector: "app-event-date",
  templateUrl: "./event-date.component.html",
  styleUrls: ["./event-date.component.scss"],
})
export class EventDateComponent implements OnInit {
  constructor() {}

  @Input() day: string;
  @Input() date: string;
  @Input() time: string;

  ngOnInit(): void {}
}
