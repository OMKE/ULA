import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { StudyProgram } from "projects/main-app/src/app/core/models/StudyProgram";
import { FacultyService } from "projects/main-app/src/app/services/faculty.service";
import { Subject } from "rxjs";
import { debounceTime, distinctUntilChanged, switchMap } from "rxjs/operators";
@Component({
    selector: "app-search",
    templateUrl: "./search.component.html",
    styleUrls: ["./search.component.scss"],
})
export class SearchComponent implements OnInit {
    constructor(private facultyService: FacultyService) {}

    private searchParam = new Subject<string>();

    @Input() facultyId: number = null;

    ngOnInit(): void {}

    @Output() onSearch: EventEmitter<StudyProgram[]> = new EventEmitter();

    studyPrograms: StudyProgram[];

    readonly studyPrograms$ = this.searchParam.pipe(
        debounceTime(250),
        distinctUntilChanged(),
        switchMap((param) =>
            this.facultyService.searchStudyProgram(param, this.facultyId)
        )
    );

    searchStudyProgram(param: string) {
        if (param != "") {
            this.searchParam.next(param);
            this.studyPrograms$.subscribe((res) => {
                this.studyPrograms = res.payload;
                this.onSearch.emit(this.studyPrograms);
            });
        }
    }
}
