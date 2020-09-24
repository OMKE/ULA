import { Exam } from "./Exam";

export interface StudentPointsCalculated {
    subjectAttendanceId: number;
    takingExamId: number;
    subject: string;
    hasFinal: boolean;
    points: number;
    exams: [Exam];
}
