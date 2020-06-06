import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-faculty-studies",
  templateUrl: "./faculty-studies.component.html",
  styleUrls: ["./faculty-studies.component.scss"],
})
export class FacultyStudiesComponent implements OnInit {
  constructor() {}

  // Faculty name, should come from store and without spaces
  name: string = "FacultyofTechnicalSciences";

  ngOnInit(): void {}
}
