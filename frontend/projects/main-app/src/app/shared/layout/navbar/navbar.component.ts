import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.scss"],
})
export class NavbarComponent implements OnInit {
  // Logo
  imageRedLight: string = "ula_logo_red_white.png";
  imageRedDark: string = "ula_logo_red_dark.png";

  navShown: boolean = false;

  constructor(private router: Router) {}

  ngOnInit(): void {}

  dark(path: string) {
    if (this.router.url == path) {
      return false;
    } else if (this.router.url == "/") {
      return false;
    } else {
      return true;
    }
  }

  getImageSrc(): string {
    if (this.router.url == "/") {
      return this.imageRedLight;
    } else {
      return this.imageRedDark;
    }
  }

  toggle() {
    if (this.navShown) {
      this.navShown = false;
    } else {
      this.navShown = true;
    }
  }

  darkToggler() {
    if (this.router.url != "/") {
      return true;
    } else {
      return false;
    }
  }
}
