import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { Video } from "../../../core/models/Video";

@Component({
  selector: "app-play-button",
  templateUrl: "./play-button.component.html",
  styleUrls: ["./play-button.component.scss"],
})
export class PlayButtonComponent implements OnInit {
  @Input()
  text: string;

  @Output() onPlay: EventEmitter<Video> = new EventEmitter();

  active: boolean = false;

  constructor() {}

  ngOnInit(): void {}

  play() {
    this.active = true;
    // We just want to catch this event, we will already know on parent component which video we want to play
    this.onPlay.emit({ id: null, name: "", format: "" });
  }
}
