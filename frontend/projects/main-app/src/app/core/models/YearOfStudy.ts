export interface YearOfStudy {
    id: number;
    averageGrade: number;
    totalEspb: number;
    subjects: [
        {
            id: number;
            studentId: number;
            subject: {
                id: number;
                yearOfStudyId: number;
                subjectRealizationId: number;
                name: string;
                semester: number;
                espb: number;
                required: boolean;
                numberOfLectures: boolean;
                numberOfPracticalLectures: number;
                otherFormsOfLectures: number;
                researchWorks: number;
                otherLectures: number;
            };
            finalGrade?: number;
        }
    ];
}
