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
import { SearchComponent } from "./layout/search/search.component";

@NgModule({
  declarations: [
    NavbarComponent,
    BigHeadingComponent,
    FooterComponent,
    LogoComponent,
    PlayButtonComponent,
    TextButtonComponent,
    SearchComponent,
  ],
  imports: [CommonModule, RouterModule],
  exports: [
    NavbarComponent,
    BigHeadingComponent,
    FooterComponent,
    LogoComponent,
    PlayButtonComponent,
    TextButtonComponent,
    SearchComponent,
  ],
})
export class SharedModule {}
