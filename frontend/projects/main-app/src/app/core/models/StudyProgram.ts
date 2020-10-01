export interface StudyProgram {
    id: number;
    facultyId: number;
    name: string;
    description: string;
    location: {
        name: string;
    };
    degree: {
        level: string;
    };
    manager: {
        id: number;
        studyProgramId: number;
        firstName: string;
        lastName: string;
        title: string;
        phoneNumber: string;
        email: string;
    };
}
