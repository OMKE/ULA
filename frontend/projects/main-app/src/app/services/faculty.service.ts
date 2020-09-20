import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { url } from "../core/models/API";
import { Faculty } from "../core/models/Faculty";
import { GenericResponse } from "../core/models/GenericResponse";
import { StudyProgramsPaginated } from "../core/models/StudyProgramsPaginated";

@Injectable({
    providedIn: "root",
})
export class FacultyService {
    constructor(private http: HttpClient) {}

    getFaculties(): Observable<GenericResponse<Faculty[]>> {
        return this.http.get<GenericResponse<Faculty[]>>(`${url}/faculty`);
    }

    getFaculty(slug: string): Observable<GenericResponse<Faculty>> {
        return this.http.get<GenericResponse<Faculty>>(
            `${url}/faculty/slug/${slug}`
        );
    }

    getStudyPrograms(
        id: number,
        size: number,
        page: number
    ): Observable<GenericResponse<StudyProgramsPaginated>> {
        return this.http.get<GenericResponse<StudyProgramsPaginated>>(
            `${url}/faculty/${id}/study-program?page=${page}&size=${size}`
        );
    }
}
