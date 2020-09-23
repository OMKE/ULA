import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { url } from "../core/models/API";
import { Faculty } from "../core/models/Faculty";
import { GenericResponse } from "../core/models/GenericResponse";
import { StudyProgram } from "../core/models/StudyProgram";
import { StudyProgramsPaginated } from "../core/models/StudyProgramsPaginated";
import { Subject } from "../core/models/Subject";
import { TeachingMaterial } from "../core/models/TeachingMaterial";
import { YearOfStudy } from "../core/models/YearOfStudy";

@Injectable({
    providedIn: "root",
})
export class FacultyService {
    constructor(private http: HttpClient) {}

    faculty: Faculty = {
        id: null,
        name: "",
        campusId: null,
        icon: "",
        contact: {
            phoneNumber: "",
            email: "",
        },
        location: {
            id: null,
            longitude: null,
            latitude: null,
            name: "",
        },
        information: {
            facultyId: null,
            history: "",
            president: "",
            mission: "",
            accreditation: "",
        },
    };

    getFaculties(): Observable<GenericResponse<Faculty[]>> {
        return this.http.get<GenericResponse<Faculty[]>>(`${url}/faculty`);
    }

    getFaculty(slug: string): Observable<GenericResponse<Faculty>> {
        return this.http.get<GenericResponse<Faculty>>(
            `${url}/faculty/slug/${slug}`
        );
    }

    searchStudyProgram(
        searchParam: string,
        facultyId: number
    ): Observable<GenericResponse<StudyProgram[]>> {
        return this.http.get<GenericResponse<StudyProgram[]>>(
            `${url}/faculty/${facultyId}/study-program?search=${searchParam}`
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

    getStudyProgram(id: number): Observable<GenericResponse<StudyProgram>> {
        return this.http.get<GenericResponse<StudyProgram>>(
            `${url}/faculty/study-program/${id}`
        );
    }

    getYearsOfStudy(
        studyProgramId: number
    ): Observable<GenericResponse<YearOfStudy[]>> {
        return this.http.get<GenericResponse<YearOfStudy[]>>(
            `${url}/faculty/study-program/${studyProgramId}/year-of-study`
        );
    }
    getSubjects(yearOfStudyId: number): Observable<GenericResponse<Subject[]>> {
        return this.http.get<GenericResponse<Subject[]>>(
            `${url}/faculty/year-of-study/${yearOfStudyId}/subjects`
        );
    }

    getTeachingMaterial(
        subjectId: number
    ): Observable<GenericResponse<TeachingMaterial[]>> {
        return this.http.get<GenericResponse<TeachingMaterial[]>>(
            `${url}/faculty/subject/${subjectId}/teaching-material`
        );
    }
}
