import { Component, Input, OnInit } from "@angular/core";
import { StudyProgram } from "projects/main-app/src/app/core/models/StudyProgram";

@Component({
  selector: "app-faculty-list-item",
  templateUrl: "./faculty-list-item.component.html",
  styleUrls: ["./faculty-list-item.component.scss"],
})
export class FacultyListItemComponent implements OnInit {
  constructor() {}

  @Input() isLast: boolean = false;

  @Input() studyProgram: StudyProgram = {
    id: null,
    facultyId: null,
    name: "",
    location: "",
    degree: "",
  };

  ngOnInit(): void {}
}
