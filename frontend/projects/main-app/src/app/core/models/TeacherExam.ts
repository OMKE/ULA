export interface TeacherExam {
    id: number;
    examTypeId: number;
    takingExamId: number;
    examEntry: {
        id: number;
        examTermId: number;
        examTerm: string;
        examId: number;
        active: boolean;
    };
    startTime: Date;
    endTime: Date;
    points: number;
    examType: string;
    finalExam: boolean;
}
