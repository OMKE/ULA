import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ContactComponent } from "./components/contact/contact.component";
import { IndexComponent } from "./components/index/index.component";

const routes: Routes = [
    {
        path: "",
        component: IndexComponent,
        data: {
            title: "University of Los Angeles",
        },
    },
    {
        path: "about",
        data: {
            title: "ULA - About university",
        },
        loadChildren: () =>
            import("./components/about/about.module").then(
                (m) => m.AboutModule
            ),
    },
    {
        path: "faculties",
        data: {
            title: "ULA - Faculties",
        },
        loadChildren: () =>
            import("./components/faculties/faculties.module").then(
                (m) => m.FacultiesModule
            ),
    },
    {
        path: "contact",
        component: ContactComponent,
    },
    {
        path: "auth",
        loadChildren: () =>
            import("./auth/auth.module").then((m) => m.AuthModule),
    },
    {
        path: "dashboard",
        loadChildren: () =>
            import("./dashboard/dashboard.module").then(
                (m) => m.DashboardModule
            ),
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
