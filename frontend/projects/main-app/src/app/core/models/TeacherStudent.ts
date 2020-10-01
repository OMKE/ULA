export interface TeacherStudent {
    id: number;
    student: {
        id: number;
        user: {
            id: number;
            username: string;
            email: string;
            profileImage: string;
            firstName: string;
            lastName: string;
        };
        phoneNumber: string;
        dateOfBirth: Date;
    };
    yearOfStudyIds: number[];
    dateOfEnrollment: Date;
    transcriptIdentifier: string;
    attendance: {
        id: number;
        studentId: number;
        subjectRealizationId: number;
        finalGrade: number;
        deleted?: boolean;
    };
    deleted?: boolean;
}
