import { Component, Input, OnInit } from "@angular/core";
import {
  customDate,
  DateFormatService,
} from "projects/main-app/src/app/core/services/date-format.service";

@Component({
  selector: "app-default-event",
  templateUrl: "./default-event.component.html",
  styleUrls: ["./default-event.component.scss"],
})
export class DefaultEventComponent implements OnInit {
  @Input() imagePath: string;

  @Input() title: string;

  @Input() description: string;

  @Input() date: Date;

  eventDate: customDate = {
    day: "",
    dayOfMonth: "",
    time: "",
  };

  constructor(private dateFormatService: DateFormatService) {}

  ngOnInit(): void {
    this.eventDate = this.dateFormatService.parseDate(this.date.toString());
  }
}
