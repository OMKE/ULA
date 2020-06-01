import { Component, OnInit } from "@angular/core";
import { Faculty } from "../../../core/models/Faculty";

@Component({
  selector: "app-faculty-list",
  templateUrl: "./faculty-list.component.html",
  styleUrls: ["./faculty-list.component.scss"],
})
export class FacultyListComponent implements OnInit {
  constructor() {}

  // Will come from store
  faculties: Faculty[] = [
    {
      id: 1,
      name: "Faculty of Technical Sciences",
      campusId: 1,
      informationId: 1,
      image: "/assets/img/faculty_images/faculty_of_technical_sciences.svg",
    },
    {
      id: 2,
      name: "Faculty of Agriculture",
      campusId: 2,
      informationId: 2,
      image: "/assets/img/faculty_images/faculty_of_agriculture.svg",
    },
    {
      id: 3,
      name: "Faculty of Law",
      campusId: 3,
      informationId: 3,
      image: "/assets/img/faculty_images/faculty_of_law.svg",
    },
    {
      id: 4,
      name: "Faculty of Economics",
      campusId: 3,
      informationId: 4,
      image: "/assets/img/faculty_images/faculty_of_economics.svg",
    },
    {
      id: 5,
      name: "Faculty of Medicine",
      campusId: 3,
      informationId: 3,
      image: "/assets/img/faculty_images/faculty_of_medicine.svg",
    },
    {
      id: 1,
      name: "Academy of Arts",
      campusId: 3,
      informationId: 3,
      image: "/assets/img/faculty_images/academy_of_arts.svg",
    },
  ];

  ngOnInit(): void {}

  getLink(name: string) {
    return name.replace(/\s+/g, "");
  }
}
