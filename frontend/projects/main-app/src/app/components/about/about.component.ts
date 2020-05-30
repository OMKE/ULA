import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-about",
  templateUrl: "./about.component.html",
  styleUrls: ["./about.component.scss"],
})
export class AboutComponent implements OnInit {
  constructor() {}

  dropDownItems: string[] = [
    "Faculty of Techinal Sciences",
    "Faculty of Law",
    "Faculty of Medicine",
  ];

  ngOnInit(): void {}
}
