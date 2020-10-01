import { User } from "./User";

export interface Teacher {
    id: number;
    biography: string;
    user: User;
    deleted: boolean;
}
