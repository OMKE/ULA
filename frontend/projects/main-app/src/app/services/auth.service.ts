import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
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
    constructor(private http: HttpClient, private errorService: ErrorService) {}

    private user: User = {
        username: "",
        password: "",
        roles: [],
    };

    private token: string = null;

    login(user: User): Observable<GenericResponse<Token>> {
        return this.http
            .post<GenericResponse<Token>>(`${url}/auth/login`, user)
            .pipe((response) => {
                response.subscribe((payload) => {
                    if (payload.errors != undefined) {
                        this.errorService.setErrors(payload.errors);
                        return response;
                    } else {
                        this.token = payload.payload.token;
                        this.user = JSON.parse(atob(this.token.split(".")[1]));
                        localStorage.setItem("user", JSON.stringify(this.user));
                        localStorage.setItem("token", this.token);
                    }
                });
                return response;
            });
    }

    register(user: User): Observable<GenericResponse<string>> {
        return this.http.post<GenericResponse<string>>(
            `${url}/auth/register`,
            user
        );
    }

    validateRoles(roles) {
        if (this.user) {
            const userRoles: Set<string> = new Set(this.user.roles);
            const matchedRoles = roles.filter((r) => userRoles.has(r));

            if (matchedRoles.length > 0) {
                return true;
            }
        }
        return false;
    }

    getToken() {
        if (!this.token) {
            const tokenLS = localStorage.getItem("token");
            if (tokenLS) {
                return tokenLS;
            }
        }
        return this.token;
    }
}
