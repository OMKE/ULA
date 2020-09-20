import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { FacultyContactComponent } from "./faculty-contact/faculty-contact.component";
import { FacultyLocationComponent } from "./faculty-location/faculty-location.component";
import { FacultyStudiesComponent } from "./faculty-studies/faculty-studies.component";
import { FacultyComponent } from "./faculty.component";

const routes: Routes = [
    {
        path: "",
        component: FacultyComponent,
        children: [
            {
                path: "studies",
                component: FacultyStudiesComponent,
                data: {
                    title: "ULA - {projectname} - Studies",
                },
            },
            {
                path: "about",
                loadChildren: () =>
                    import("./faculty-about/faculty-about.module").then(
                        (m) => m.FacultyAboutModule
                    ),
            },
            {
                path: "location",
                component: FacultyLocationComponent,
            },
            {
                path: "contact",
                component: FacultyContactComponent,
            },
        ],
    },
];

@NgModule({
    declarations: [],
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class FacultyRoutingModule {}
