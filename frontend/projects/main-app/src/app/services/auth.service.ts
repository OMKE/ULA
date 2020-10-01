import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { url } from "../core/models/API";
import { GenericResponse } from "../core/models/GenericResponse";
import { Token } from "../core/models/Token";
import { User } from "../core/models/User";
import { ErrorService } from "./error.service";

@Injectable({
    providedIn: "root",
})
export class AuthService {
    constructor(
        private http: HttpClient,
        private errorService: ErrorService,
        private router: Router
    ) {}

    private user: User = {
        username: "",
        password: "",
        roles: [],
    };

    private token: string = null;

    login(user: User): Observable<GenericResponse<Token>> {
        return this.http.post<GenericResponse<Token>>(
            `${url}/auth/login`,
            user
        );
    }

    register(user: User): Observable<GenericResponse<string>> {
        return this.http.post<GenericResponse<string>>(
            `${url}/auth/register`,
            user
        );
    }

    validateRoles(roles) {
        if (this.getUser()) {
            const userRoles: Set<string> = new Set(this.user.roles);
            const matchedRoles = roles.filter((r) => userRoles.has(r));

            if (matchedRoles.length > 0) {
                return true;
            }
        }

        return false;
    }

    logout(): void {
        localStorage.removeItem("user");
        localStorage.removeItem("token");
        this.router.navigate(["/auth/login"]);
    }

    setToken(token: Token) {
        this.token = token.token;
        this.user = JSON.parse(atob(this.token.split(".")[1]));
        localStorage.setItem("user", JSON.stringify(this.user));
        localStorage.setItem("token", this.token);
    }

    getToken() {
        if (!this.token) {
            const token = localStorage.getItem("token");
            if (token) {
                this.token = token;
                return token;
            }
        }
        return this.token;
    }

    getUser(): User {
        const user = JSON.parse(localStorage.getItem("user"));
        if (user) {
            this.user = user;
            return user;
        }
    }

    getRoles(): string[] {
        const user: User = JSON.parse(localStorage.getItem("user"));
        if (user) {
            return user.roles;
        }
    }

    isUser() {
        if (
            this.getRoles().includes("USER") &&
            !this.getRoles().includes("STUDENT") &&
            !this.getRoles().includes("TEACHER") &&
            !this.getRoles().includes("ADMIN")
        ) {
            return true;
        }
        return false;
    }
    isAdmin() {
        const foundRole = this.getUser().roles.find((e) => e === "ADMIN");
        if (foundRole) {
            return true;
        }
        return false;
    }
    isStudent() {
        const foundRole = this.getUser().roles.find((e) => e === "STUDENT");
        if (foundRole) {
            return true;
        }
        return false;
    }

    isTeacher() {
        const foundRole = this.getUser().roles.find((e) => e === "TEACHER");
        if (foundRole) {
            return true;
        }
        return false;
    }
}
