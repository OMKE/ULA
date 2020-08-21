import { Component, Input, OnInit } from "@angular/core";

@Component({
  selector: "app-event-info",
  templateUrl: "./event-info.component.html",
  styleUrls: ["./event-info.component.scss"],
})
export class EventInfoComponent implements OnInit {
  @Input() title: string;

  @Input() desc: string;

  constructor() {}

  ngOnInit(): void {}
}
