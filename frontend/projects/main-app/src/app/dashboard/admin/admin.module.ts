import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { AdminComponent } from "../admin/admin.component";
import { AdminRoutingModule } from "./admin-routing.module";
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';

@NgModule({
    declarations: [AdminComponent, AdminNavbarComponent],
    imports: [CommonModule, AdminRoutingModule],
})
export class AdminModule {}
