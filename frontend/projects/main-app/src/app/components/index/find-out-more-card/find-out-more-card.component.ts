import { Component, Input, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-find-out-more-card",
  templateUrl: "./find-out-more-card.component.html",
  styleUrls: ["./find-out-more-card.component.scss"],
})
export class FindOutMoreCardComponent implements OnInit {
  @Input() title: string;

  @Input() iconPath: string;

  @Input() link: string;

  constructor(private router: Router) {}

  ngOnInit(): void {}

  navigate() {
    this.router.navigate([this.link]);
  }
}
