import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { url } from "../core/models/API";
import { GenericResponse } from "../core/models/GenericResponse";
import {
    Information,
    President,
    Publishing,
    TeachingStaff,
} from "../core/models/UniversityInformation";

@Injectable({
    providedIn: "root",
})
export class UniversityService {
    constructor(private http: HttpClient) {}

    getAbout(): Observable<GenericResponse<Information>> {
        return this.http.get<GenericResponse<Information>>(
            `${url}/university/information/about`
        );
    }

    getHistory(): Observable<GenericResponse<History>> {
        return this.http.get<GenericResponse<History>>(
            `${url}/university/information/history`
        );
    }

    getPresident(): Observable<GenericResponse<President>> {
        return this.http.get<GenericResponse<President>>(
            `${url}/university/information/president`
        );
    }
    getTeachingStaff(): Observable<GenericResponse<TeachingStaff>> {
        return this.http.get<GenericResponse<TeachingStaff>>(
            `${url}/university/information/teaching-staff`
        );
    }

    getPublishing(): Observable<GenericResponse<Publishing>> {
        return this.http.get<GenericResponse<Publishing>>(
            `${url}/university/information/publishing`
        );
    }
}
