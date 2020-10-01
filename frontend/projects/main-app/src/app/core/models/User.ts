export interface User {
    id?: number;
    username: string;
    password: string;
    confirmPassword?: string;
    email?: string;
    firstName?: string;
    lastName?: string;
    profileImage?: string;
    acceptTerms?: boolean;
    roles: string[];
}
