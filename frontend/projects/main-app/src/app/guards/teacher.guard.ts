import { Injectable } from "@angular/core";
import {
    ActivatedRouteSnapshot,
    CanActivate,
    Router,
    RouterStateSnapshot,
    UrlTree,
} from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "../services/auth.service";

@Injectable({
    providedIn: "root",
})
export class TeacherGuard implements CanActivate {
    constructor(private authService: AuthService, private router: Router) {}

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ):
        | Observable<boolean | UrlTree>
        | Promise<boolean | UrlTree>
        | boolean
        | UrlTree {
        if (this.authService.isTeacher()) {
            return true;
        } else if (this.authService.isStudent()) {
            this.router.navigate(["dashboard/student"]);
        } else if (this.authService.isAdmin()) {
            this.router.navigate(["dashboard/admin"]);
        }
        return false;
    }
}
