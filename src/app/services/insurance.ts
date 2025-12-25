import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InsuranceService {

  private api = "http://localhost:3333";

  constructor(private http: HttpClient) {}

  getPlans(): Observable<any[]> {
    return this.http.get<any[]>(this.api + "/plans");
  }

  getPlanById(id:number): Observable<any[]> {
    return this.http.get<any[]>(this.api + "/plans?planId=" + id);
  }

  saveBooking(data:any) {
    return this.http.post(this.api + "/bookings", data);
  }

  getBookings(): Observable<any[]> {
    return this.http.get<any[]>(this.api + "/bookings");
  }
}
