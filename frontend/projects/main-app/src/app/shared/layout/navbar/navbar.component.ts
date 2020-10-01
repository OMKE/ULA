import { Component, OnInit } from "@angular/core";
import { NavigationStart, Router } from "@angular/router";

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

    constructor(private router: Router) {
        // When navigating from faculty to all faculties, navigation is still show so we check if there was navigation started
        this.router.events.subscribe((event) => {
            if (event instanceof NavigationStart) {
                this.navShown = false;
            }
        });
    }

    ngOnInit(): void {}

    white() {
        if (this.router.url == "/") {
            if (this.navShown) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
    active(path: string): boolean {
        return this.router.url.split("/").includes(path.slice(1));
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
