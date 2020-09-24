import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Admin } from "../core/models/Admin";
import { url } from "../core/models/API";
import { GenericResponse } from "../core/models/GenericResponse";
import { Student } from "../core/models/Student";
import { Teacher } from "../core/models/Teacher";
import { AddAdminRequest } from "../core/requests/AddAdminRequst";
import { AddStudentOnYearRequest } from "../core/requests/AddStudentOnYearRequest";
import { AddStudentRequest } from "../core/requests/AddStudentRequest";
import { AddTeacherRequest } from "../core/requests/AddTeacherRequest";

@Injectable({
    providedIn: "root",
})
export class AdminService {
    constructor(private http: HttpClient) {}

    getAllAdmins(): Observable<GenericResponse<Admin[]>> {
        return this.http.get<GenericResponse<Admin[]>>(`${url}/auth/admin`);
    }
    getOneAdmin(id: number): Observable<GenericResponse<Admin>> {
        return this.http.get<GenericResponse<Admin>>(`${url}/auth/admin/${id}`);
    }

    addAdmin(request: AddAdminRequest): Observable<GenericResponse<string>> {
        return this.http.post<GenericResponse<string>>(
            `${url}/auth/admin`,
            request
        );
    }
    deleteAdmin(id: number): Observable<GenericResponse<string>> {
        return this.http.delete<GenericResponse<string>>(
            `${url}/auth/admin/${id}`
        );
    }

    getAllTeachers(): Observable<GenericResponse<Teacher[]>> {
        return this.http.get<GenericResponse<Teacher[]>>(`${url}/auth/teacher`);
    }

    getOneTeacher(id: number): Observable<GenericResponse<Teacher>> {
        return this.http.get<GenericResponse<Teacher>>(
            `${url}/auth/teacher/${id}`
        );
    }
    addTeacher(
        request: AddTeacherRequest
    ): Observable<GenericResponse<string>> {
        return this.http.post<GenericResponse<string>>(
            `${url}/auth/teacher`,
            request
        );
    }
    deleteTeacher(id: number): Observable<GenericResponse<string>> {
        return this.http.delete<GenericResponse<string>>(
            `${url}/auth/teacher/${id}`
        );
    }

    getAllStudents(): Observable<GenericResponse<Student[]>> {
        return this.http.get<GenericResponse<Student[]>>(`${url}/auth/student`);
    }
    getOneStudent(id: number): Observable<GenericResponse<Student>> {
        return this.http.get<GenericResponse<Student>>(
            `${url}/auth/student/${id}`
        );
    }
    addStudent(
        request: AddStudentRequest
    ): Observable<GenericResponse<string>> {
        return this.http.post<GenericResponse<string>>(
            `${url}/auth/student`,
            request
        );
    }
    deleteStudent(id: number): Observable<GenericResponse<string>> {
        return this.http.delete<GenericResponse<string>>(
            `${url}/auth/student/${id}`
        );
    }

    addStudentOnYear(
        request: AddStudentOnYearRequest
    ): Observable<GenericResponse<string>> {
        return this.http.post<GenericResponse<string>>(
            `${url}/faculty/student-on-year`,
            request
        );
    }
}
