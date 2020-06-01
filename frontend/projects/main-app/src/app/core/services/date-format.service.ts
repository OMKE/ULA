import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class DateFormatService {
  constructor() {}

  parseDate(dateToParse: string): customDate {
    let date = new Date(dateToParse);

    const dayOfMonth = this.deleteNull(dateToParse.split("-")[2].split(" ")[0]);
    let minutes: any = date.getMinutes();
    if (minutes < 10) {
      minutes = `0${minutes}`;
    }
    const twelveHourFormat = this.tConv24(`0${date.getHours()}:${minutes}`);

    return {
      day: this.getDayName(date.getDay() - 1),
      time: twelveHourFormat,
      dayOfMonth: `${dayOfMonth}${this.getDateOrdinal(
        parseInt(dayOfMonth)
      )} ${this.getMonthName(date.getMonth())}`,
    };
  }

  getDateOrdinal(day: number) {
    if (day > 3 && day < 21) return `th`;
    switch (day % 10) {
      case 1:
        return `st`;
      case 2:
        return `nd`;
      case 3:
        return `rd`;
      default:
        return `th`;
    }
  }

  getMonthName(monthIndex: number): string {
    const months = [
      "Jan",
      "Feb",
      "Mar",
      "Apr",
      "May",
      "June",
      "July",
      "Aug",
      "Sept",
      "Oct",
      "Nov",
      "Dec",
    ];
    return months[monthIndex];
  }
  getDayName(dayIndex: number): string {
    const days = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];
    return days[dayIndex];
  }

  deleteNull(val: string): string {
    if (val[0] == "0") {
      return val[1];
    } else {
      return val;
    }
  }

  fineseTConv24(timeToParse: string): string {
    let time = this.tConv24(timeToParse);
    time = time.split(":").join(".");

    return time;
  }

  tConv24(time24) {
    let ts = time24;
    let H = +ts.substr(0, 2);
    let h: any = H % 12 || 12;
    h = h < 10 ? "0" + h : h; // leading 0 at the left for 1 digit hours
    let ampm = H < 12 ? " AM" : " PM";
    ts = h + ts.substr(2, 3) + ampm;
    return ts;
  }
}

export interface customDate {
  day: string;
  time: string;
  dayOfMonth: string;
}
