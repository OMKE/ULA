export interface Exam {
    id: number;
    examEntry?: {
        id: number;
        examType: string;
        active: boolean;
    };
    startTime: Date;
    endTime: Date;
    points: number;
    examType: string;
    finalExam: boolean;
    outcome?: {
        id: number;
        examId: number;
        description: string;
    };
}
