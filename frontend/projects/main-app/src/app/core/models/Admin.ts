import { User } from "./User";

export interface Admin {
    id: number;
    user: User;
    deleted: boolean;
}
