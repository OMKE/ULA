import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { url } from "../core/models/API";
import { Exam } from "../core/models/Exam";
import { GenericResponse } from "../core/models/GenericResponse";
import { Student } from "../core/models/Student";
import { StudentSubject } from "../core/models/StudentSubject";
import { TakingExam } from "../core/models/TakingExam";
import { YearOfStudy } from "../core/models/YearOfStudy";
import { ExamEntryRequest } from "../core/requests/ExamEntryRequest";

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
        subjectId: number,
        page: number,
        size: number
    ): Observable<GenericResponse<Notification[]>> {
        return this.http.get<GenericResponse<Notification[]>>(
            `${url}/student/subject/${subjectId}/notification?page=${page}&size=${size}`
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
    getOneSubject(id: number): Observable<GenericResponse<StudentSubject>> {
        return this.http.get<GenericResponse<StudentSubject>>(
            `${url}/student/subject/${id}`
        );
    }
    getTakingExam(subjectId: number): Observable<GenericResponse<TakingExam>> {
        return this.http.get<GenericResponse<TakingExam>>(
            `${url}/student/subject/${subjectId}/exam`
        );
    }
    getExam(
        subjectId: number,
        examId: number
    ): Observable<GenericResponse<Exam>> {
        return this.http.get<GenericResponse<Exam>>(
            `${url}/student/subject/${subjectId}/exam/${examId}`
        );
    }
    addExamEntry(
        subjectId: number,
        examId: number,
        entry: ExamEntryRequest
    ): Observable<GenericResponse<string>> {
        return this.http.post<GenericResponse<string>>(
            `${url}/student/subject/${subjectId}/exam/${examId}`,
            entry
        );
    }
    getAllNotPassedSubjects(): Observable<GenericResponse<StudentSubject[]>> {
        return this.http.get<GenericResponse<StudentSubject[]>>(
            `${url}/student/subject?fetch=not-passed`
        );
    }
    getAllPassedSubjects(): Observable<GenericResponse<StudentSubject[]>> {
        return this.http.get<GenericResponse<StudentSubject[]>>(
            `${url}/student/subject?fetch=passed`
        );
    }

    // getExams(subjectId: number)
}
