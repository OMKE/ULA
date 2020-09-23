import {
    HttpEvent,
    HttpHandler,
    HttpInterceptor,
    HttpRequest,
} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "../../services/auth.service";

@Injectable({
    providedIn: "root",
})
export class HttpInterceptorService implements HttpInterceptor {
    constructor(private authService: AuthService, private router: Router) {}
    intercept(
        req: HttpRequest<any>,
        next: HttpHandler
    ): Observable<HttpEvent<any>> {
        const token = this.authService.getToken();
        if (token != null) {
            let newRequest = req.clone({
                headers: req.headers.set("Authorization", token),
            });
            return next.handle(newRequest);
        }
        return next.handle(req);
    }
}
