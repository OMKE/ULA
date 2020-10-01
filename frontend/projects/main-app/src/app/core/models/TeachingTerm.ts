export interface TeachingTerm {
    id: number;
    subjectRealizationId: number;
    type: {
        id: number;
        name: string;
    };
    teachingOutcome: {
        id: number;
        teachingTermId: number;
        description: string;
    };
    startTime: Date;
    endTime: Date;
}
