import { Component, Input, OnInit } from "@angular/core";

@Component({
  selector: "app-search",
  templateUrl: "./search.component.html",
  styleUrls: ["./search.component.scss"],
})
export class SearchComponent implements OnInit {
  constructor() {}

  // Should get fire an action to search for typed text

  // Should do the searching

  // Should notify the store to show the search results

  // Should get the placeholder text through Input
  @Input() placeholder: string;

  ngOnInit(): void {}
}
