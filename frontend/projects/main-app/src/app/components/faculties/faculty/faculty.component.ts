import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-faculty",
  templateUrl: "./faculty.component.html",
  styleUrls: ["./faculty.component.scss"],
})
export class FacultyComponent implements OnInit {
  constructor(private route: ActivatedRoute) {}

  // Will come from store
  heading: string = "Faculty of Technical Sciences";

  ngOnInit(): void {}
}
