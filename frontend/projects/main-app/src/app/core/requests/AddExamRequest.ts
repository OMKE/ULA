export interface AddExamRequest {
    typeId: number;
    examTermId: number;
    startTime: Date;
    endTime: Date;
    finalExam: boolean;
}
