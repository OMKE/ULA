import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-footer",
  templateUrl: "./footer.component.html",
  styleUrls: ["./footer.component.scss"],
})
export class FooterComponent implements OnInit {
  constructor() {}

  currentYear: string;

  ngOnInit(): void {
    this.currentYear = new Date().getFullYear().toString();
  }
}
