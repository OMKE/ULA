import { StudentOnYear } from "./StudentOnYear";
import { User } from "./User";

export interface Student {
    id: number;
    user: User;
    ssn: string;
    phoneNumber: string;
    dateOfBirth: Date;
    studentOnYear?: StudentOnYear;
}
