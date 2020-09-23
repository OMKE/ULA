export interface User {
    username: string;
    password: string;
    confirmPassword?: string;
    email?: string;
    firstName?: string;
    lastName?: string;
    acceptTerms?: boolean;
    roles: string[];
}
