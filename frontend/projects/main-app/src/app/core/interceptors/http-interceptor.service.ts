import {
    HttpEvent,
    HttpHandler,
    HttpInterceptor,
    HttpRequest,
    HttpResponse,
} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { tap } from "rxjs/operators";
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
            return next.handle(newRequest).pipe(
                tap((evt) => {
                    if (evt instanceof HttpResponse) {
                        if (evt.body.status == "ACCESS_DENIED") {
                            this.authService.logout();
                            this.router.navigate(["/auth/login"]);
                        }
                    }
                })
            );
        }
        return next.handle(req);
    }
}
