import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { FacultiesComponent } from "./faculties.component";
import { FacultyListComponent } from "./faculty-list/faculty-list.component";

const routes: Routes = [
    {
        path: "",
        component: FacultiesComponent,
        data: {
            title: "ULA - Faculties",
        },
        children: [
            {
                path: "",
                component: FacultyListComponent,
            },
            {
                path: ":name",
                loadChildren: () =>
                    import("./faculty/faculty.module").then(
                        (m) => m.FacultyModule
                    ),
                data: {
                    title: "ULA - Faculty",
                },
            },
        ],
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class FacultiesRoutingModule {}
