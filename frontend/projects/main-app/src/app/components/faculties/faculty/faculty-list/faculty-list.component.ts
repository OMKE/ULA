import { Component, OnInit } from "@angular/core";
import { StudyProgram } from "projects/main-app/src/app/core/models/StudyProgram";

@Component({
  selector: "app-faculty-list",
  templateUrl: "./faculty-list.component.html",
  styleUrls: ["./faculty-list.component.scss"],
})
export class FacultyListComponent implements OnInit {
  constructor() {}

  // Faculty study programs, should come from store
  studyPrograms: StudyProgram[] = [
    {
      id: 1,
      facultyId: 1,
      name: "Production Engineering",
      location: "Main Campus",
      degree: "Undergraduate",
    },
    {
      id: 1,
      facultyId: 1,
      name: "Computer Science",
      location: "Main Campus",
      degree: "Undergraduate",
    },
    {
      id: 1,
      facultyId: 1,
      name: "Biomedical Engineering",
      location: "Main Campus",
      degree: "Undergraduate",
    },
    {
      id: 1,
      facultyId: 1,
      name: "Mechatronics",
      location: "Main Campus",
      degree: "Undergraduate",
    },
    {
      id: 1,
      facultyId: 1,
      name: "Industrial Engineering",
      location: "Main Campus",
      degree: "Undergraduate",
    },
    {
      id: 1,
      facultyId: 1,
      name: "Graphic Engineering and Design",
      location: "Main Campus",
      degree: "Undergraduate",
    },
    {
      id: 1,
      facultyId: 1,
      name: "Computing and Control Engineering",
      location: "Main Campus",
      degree: "Undergraduate",
    },
  ];

  ngOnInit(): void {}
}
