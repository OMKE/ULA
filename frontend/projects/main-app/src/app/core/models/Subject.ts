export interface Subject {
    id: number;
    yearOfStudyId: number;
    subjectRealizationId?: number;
    name: string;
    semester: number;
    espb: number;
    required: boolean;
    numberOfLectures: boolean;
    numberOfPracticalLectures: number;
    otherFormsOfLectures: number;
    researchWorks: number;
    otherLectures: number;
    syllabus: {
        id: number;
        subjectId: number;
        content: string;
    };
}
