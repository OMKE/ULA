import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { url } from "../core/models/API";
import { GenericResponse } from "../core/models/GenericResponse";
import { User } from "../core/models/User";
import { UpdateFirstNameLastName } from "../core/requests/UpdateFirstNameLastName";
import { UpdatePassword } from "../core/requests/UpdatePassword";

@Injectable({
    providedIn: "root",
})
export class UserService {
    constructor(private http: HttpClient) {}

    getUserData(): Observable<GenericResponse<User>> {
        return this.http.get<GenericResponse<User>>(`${url}/auth/me`);
    }

    updateUserData(
        updateRequest: UpdateFirstNameLastName
    ): Observable<GenericResponse<string>> {
        return this.http.put<GenericResponse<string>>(
            `${url}/auth/me`,
            updateRequest
        );
    }

    updateUserPassword(
        updatePassword: UpdatePassword
    ): Observable<GenericResponse<string>> {
        return this.http.put<GenericResponse<string>>(
            `${url}/auth/me/change-password`,
            updatePassword
        );
    }

    addImage(image: File): Observable<GenericResponse<string>> {
        const formData = new FormData();
        formData.append("image", image);
        return this.http.post<GenericResponse<string>>(
            `${url}/auth/me/profile-image`,
            formData
        );
    }
    deleteImage(): Observable<GenericResponse<string>> {
        return this.http.delete<GenericResponse<string>>(
            `${url}/auth/me/profile-image`
        );
    }
}
