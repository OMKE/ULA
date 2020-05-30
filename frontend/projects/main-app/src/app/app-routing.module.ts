import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
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
      import("./components/about/about.module").then((m) => m.AboutModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
