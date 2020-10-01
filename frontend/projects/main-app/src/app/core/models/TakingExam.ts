import { Exam } from "./Exam";

export interface TakingExam {
    id: number;
    subjectAttendanceId: number;
    points: number;
    note: string;
    exams: [Exam];
}
