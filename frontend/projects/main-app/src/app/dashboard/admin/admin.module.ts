import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { AdminComponent } from "../admin/admin.component";
import { AdminRoutingModule } from "./admin-routing.module";

@NgModule({
    declarations: [AdminComponent],
    imports: [CommonModule, AdminRoutingModule],
})
export class AdminModule {}
