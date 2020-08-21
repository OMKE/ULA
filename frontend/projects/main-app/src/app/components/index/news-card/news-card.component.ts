import { Component, OnInit } from "@angular/core";
import { Article } from "../../../core/models/Article";

@Component({
  selector: "app-news-card",
  templateUrl: "./news-card.component.html",
  styleUrls: ["./news-card.component.scss"],
})
export class NewsCardComponent implements OnInit {
  article: Article;

  constructor() {}

  ngOnInit(): void {}
}
