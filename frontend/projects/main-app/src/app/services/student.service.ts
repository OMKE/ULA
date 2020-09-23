import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { url } from "../core/models/API";
import { GenericResponse } from "../core/models/GenericResponse";
import { Student } from "../core/models/Student";
import { YearOfStudy } from "../core/models/YearOfStudy";

@Injectable({
    providedIn: "root",
})
export class StudentService {
    constructor(private http: HttpClient) {}

    getStudent(): Observable<GenericResponse<Student>> {
        return this.http.get<GenericResponse<Student>>(`${url}/student/me`);
    }

    getNotifications(
        page: number,
        size: number
    ): Observable<GenericResponse<Notification[]>> {
        return this.http.get<GenericResponse<Notification[]>>(
            `${url}/student/notification?page=${page}&size=${size}`
        );
    }

    getBasedOnSubject(
        subjectId: number
    ): Observable<GenericResponse<Notification[]>> {
        return this.http.get<GenericResponse<Notification[]>>(
            `${url}/student/subject/${subjectId}/notification`
        );
    }

    getYearOfStudies(): Observable<GenericResponse<YearOfStudy[]>> {
        return this.http.get<GenericResponse<YearOfStudy[]>>(
            `${url}/student/year-of-study`
        );
    }
    getOneYearOfStudy(id: number): Observable<GenericResponse<YearOfStudy>> {
        return this.http.get<GenericResponse<YearOfStudy>>(
            `${url}/student/year-of-study/${id}`
        );
    }

    // getExams(subjectId: number)
}
