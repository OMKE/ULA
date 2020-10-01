export interface AddTeachingTermRequest {
    subjectId: number;
    typeId: number;
    startTime: Date;
    endTime: Date;
    teachingMaterialName: string;
    authors: [
        {
            firstName: string;
            lastName: string;
        }
    ];
    teachingTermOutcomeDescription: string;
    teachingMaterialPublicationDate: Date;
}
