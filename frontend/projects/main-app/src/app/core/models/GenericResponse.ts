export interface GenericResponse<T> {
    status: string;
    payload: T;
    errors?: string[];
}
