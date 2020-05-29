import { Component, Input, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-text-button",
  templateUrl: "./text-button.component.html",
  styleUrls: ["./text-button.component.scss"],
})
export class TextButtonComponent implements OnInit {
  @Input()
  link: string;

  @Input()
  text: string;

  constructor(private router: Router) {}

  ngOnInit(): void {}

  navigate() {
    this.router.navigate([this.link]);
  }
}
