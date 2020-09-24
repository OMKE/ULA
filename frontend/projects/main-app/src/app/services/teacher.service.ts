import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { url } from "../core/models/API";
import { GenericResponse } from "../core/models/GenericResponse";
import { StudentPointsCalculated } from "../core/models/StudentPointsCalculated";
import { Subject } from "../core/models/Subject";
import { SubjectNotificationType } from "../core/models/SubjectNotificationType";
import { TakingExam } from "../core/models/TakingExam";
import { TeacherExam } from "../core/models/TeacherExam";
import { TeacherStudent } from "../core/models/TeacherStudent";
import { TeachingTerm } from "../core/models/TeachingTerm";
import { TeachingType } from "../core/models/TeachingType";
import { AddExamRequest } from "../core/requests/AddExamRequest";
import { AddNotificationRequest } from "../core/requests/AddNotificationRequest";
import { AddTeachingTermRequest } from "../core/requests/AddTeachingTermRequest";
import { UpdateFinalGradeRequest } from "../core/requests/UpdateFinalGradeRequest";
import { UpdateStudentExamRequest } from "../core/requests/UpdateStudentExamRequest";
import { UpdateStudentPointsRequest } from "../core/requests/UpdateStudentPointsRequest";
import { UpdateSubjectSyllabusRequest } from "../core/requests/UpdateSubjectSyllabusRequest";

@Injectable({
    providedIn: "root",
})
export class TeacherService {
    constructor(private http: HttpClient) {}

    getAllSubjects(): Observable<GenericResponse<Subject[]>> {
        return this.http.get<GenericResponse<Subject[]>>(
            `${url}/teacher/subject`
        );
    }
    getOneSubject(id: number): Observable<GenericResponse<Subject>> {
        return this.http.get<GenericResponse<Subject>>(
            `${url}/teacher/subject/${id}`
        );
    }

    getStudentsBySubject(
        subjectId: number,
        page: number,
        size: number
    ): Observable<GenericResponse<TeacherStudent[]>> {
        return this.http.get<GenericResponse<TeacherStudent[]>>(
            `${url}/teacher/subject/${subjectId}/student?page=${page}&size=${size}`
        );
    }
    getOneStudentBySubject(
        subjectId: number,
        studentId: number
    ): Observable<GenericResponse<TeacherStudent>> {
        return this.http.get<GenericResponse<TeacherStudent>>(
            `${url}/teacher/subject/${subjectId}/student/${studentId}`
        );
    }

    updateFinalGrade(
        subjectId: number,
        studentId: number,
        request: UpdateFinalGradeRequest
    ): Observable<GenericResponse<string>> {
        return this.http.put<GenericResponse<string>>(
            `${url}/teacher/subject/${subjectId}/student/${studentId}/final-grade`,
            request
        );
    }

    getNotifications(
        page: number,
        size: number
    ): Observable<GenericResponse<Notification[]>> {
        return this.http.get<GenericResponse<Notification[]>>(
            `${url}/teacher/notification?page=${page}&size=${size}`
        );
    }

    getNotificationTypes(): Observable<
        GenericResponse<SubjectNotificationType[]>
    > {
        return this.http.get<GenericResponse<SubjectNotificationType[]>>(
            `${url}/faculty/subject-notification-type`
        );
    }

    addNotification(
        request: AddNotificationRequest
    ): Observable<GenericResponse<string>> {
        return this.http.post<GenericResponse<string>>(
            `${url}/teacher/notification`,
            request
        );
    }
    deleteNotification(id: number): Observable<GenericResponse<string>> {
        return this.http.delete<GenericResponse<string>>(
            `${url}/teacher/notification/${id}`
        );
    }

    getTeachingTerm(
        subjectId: number,
        page: number,
        size: number
    ): Observable<GenericResponse<TeachingTerm[]>> {
        return this.http.get<GenericResponse<TeachingTerm[]>>(
            `${url}/teacher/teaching-term/subject/${subjectId}?page=${page}&size=${size}`
        );
    }

    getTeachingTermTypes(): Observable<GenericResponse<TeachingType[]>> {
        return this.http.get<GenericResponse<TeachingType[]>>(
            `${url}/faculty/teaching-type`
        );
    }

    addTeachingTerm(
        request: AddTeachingTermRequest
    ): Observable<GenericResponse<string>> {
        return this.http.post<GenericResponse<string>>(
            `${url}/teacher/teaching-term`,
            request
        );
    }
    updateSubjectSyllabus(
        subjectId: number,
        request: UpdateSubjectSyllabusRequest
    ): Observable<GenericResponse<string>> {
        return this.http.put<GenericResponse<string>>(
            `${url}/teacher/subject/${subjectId}/syllabus`,
            request
        );
    }

    addExam(
        subjectId: number,
        request: AddExamRequest
    ): Observable<GenericResponse<string>> {
        return this.http.post<GenericResponse<string>>(
            `${url}/teacher/subject/${subjectId}/exam`,
            request
        );
    }

    getAllStudentExam(
        subjectId: number,
        studentId: number
    ): Observable<GenericResponse<TakingExam>> {
        return this.http.get<GenericResponse<TakingExam>>(
            `${url}/teacher/subject/${subjectId}/student/${studentId}/taking-exam`
        );
    }

    getStudentPointsCalculated(
        subjectId: number,
        studentId: number
    ): Observable<GenericResponse<StudentPointsCalculated>> {
        return this.http.get<GenericResponse<StudentPointsCalculated>>(
            `${url}/teacher/subject/${subjectId}/student/${studentId}/taking-exam/point`
        );
    }
    updateStudentPoints(
        subjectId: number,
        studentId: number,
        request: UpdateStudentPointsRequest
    ): Observable<GenericResponse<string>> {
        return this.http.put<GenericResponse<string>>(
            `${url}/teacher/subject/${subjectId}/student/${studentId}/taking-exam`,
            request
        );
    }

    getOneStudentExam(
        subjectId: number,
        studentId: number,
        examId: number
    ): Observable<GenericResponse<TeacherExam>> {
        return this.http.get<GenericResponse<TeacherExam>>(
            `${url}/teacher/subject/${subjectId}/student/${studentId}/taking-exam/exam/${examId}`
        );
    }

    updateStudentExam(
        subjectId: number,
        studentId: number,
        examId: number,
        request: UpdateStudentExamRequest
    ): Observable<GenericResponse<string>> {
        return this.http.put<GenericResponse<string>>(
            `${url}/teacher/subject/${subjectId}/student/${studentId}/taking-exam/exam/${examId}`,
            request
        );
    }

    getAllStudents(
        page: number,
        size: number
    ): Observable<GenericResponse<TeacherStudent[]>> {
        return this.http.get<GenericResponse<TeacherStudent[]>>(
            `${url}/teacher/student?page=${page}&size=${size}`
        );
    }
    getOneStudent(
        studentId: number
    ): Observable<GenericResponse<TeacherStudent>> {
        return this.http.get<GenericResponse<TeacherStudent>>(
            `${url}/teacher/student/${studentId}`
        );
    }
    searchStudentsByFirstNameOrLastNameOrTranscriptIdentifierOrYearOfEnrollment(
        searchParam: string
    ): Observable<GenericResponse<TeacherStudent[]>> {
        return this.http.get<GenericResponse<TeacherStudent[]>>(
            `${url}/teacher/student?search=${searchParam}`
        );
    }
}
