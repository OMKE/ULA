import { Injectable } from "@angular/core";

@Injectable({
    providedIn: "root",
})
export class ErrorService {
    constructor() {}

    // private errors: BehaviorSubject<string[]> = new BehaviorSubject<string[]>(
    //     []
    // );

    // setErrors(errors: string[]): void {
    //     this.errors.next(errors);
    // }

    // getErrors(): Subject<string[]> {
    //     return this.errors;
    // }

    // clear() {
    //     this.errors.complete();
    // }

    private errors: string[] = [];

    getErrors(): string[] {
        return this.errors;
    }

    setErrors(errors: string[]) {
        this.errors = errors;
    }
}
