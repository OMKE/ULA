import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { ErrorComponent } from "../shared/layout/error/error.component";
import {
    BigHeadingComponent,
    FooterComponent,
    LogoComponent,
    NavbarComponent,
    PlayButtonComponent,
    TextButtonComponent,
} from "./index";

@NgModule({
    declarations: [
        NavbarComponent,
        BigHeadingComponent,
        FooterComponent,
        LogoComponent,
        PlayButtonComponent,
        TextButtonComponent,
        ErrorComponent,
    ],
    imports: [CommonModule, RouterModule],
    exports: [
        NavbarComponent,
        BigHeadingComponent,
        FooterComponent,
        LogoComponent,
        PlayButtonComponent,
        TextButtonComponent,
        ErrorComponent,
    ],
})
export class SharedModule {}
