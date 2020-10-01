export interface TeachingMaterial {
    id: number;
    teachingTermId: number;
    name: string;
    publicationDate: Date;
    authors: [
        {
            id: number;
            teachingMaterialId: number;
            firstName: string;
            lastName: string;
        }
    ];
    files?: [];
}
