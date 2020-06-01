import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
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
  ],
  imports: [CommonModule, RouterModule],
  exports: [
    NavbarComponent,
    BigHeadingComponent,
    FooterComponent,
    LogoComponent,
    PlayButtonComponent,
    TextButtonComponent,
  ],
})
export class SharedModule {}
