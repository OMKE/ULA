import { StudyProgram } from "./StudyProgram";

export interface StudyProgramsPaginated {
    studyPrograms: StudyProgram[];
    totalPages: number;
}
