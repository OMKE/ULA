import { Component, OnInit } from "@angular/core";
import { Address } from "projects/main-app/src/app/core/models/Address";

@Component({
  selector: "app-faculty-contact",
  templateUrl: "./faculty-contact.component.html",
  styleUrls: ["./faculty-contact.component.scss"],
})
export class FacultyContactComponent implements OnInit {
  constructor() {}

  // Store
  name: string = "Faculty of Technical Sciences";

  // Should get from faculty info
  address: Address = {
    id: null,
    cityName: "Los Angeles",
    streetName: "Hillhaven Drive",
    number: "2520",
    postalCode: "CA 90029",
  };
  email: string = "info-fts@ula.com";

  phoneNumber: string = "202-555-0187";

  getPhoneNumber(): string {
    const pN = this.phoneNumber.split("-");
    return `(${pN[0]})-${pN[1]}-${pN[2]}`;
  }

  ngOnInit(): void {}
}
