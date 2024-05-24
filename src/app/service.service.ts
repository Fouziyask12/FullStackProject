import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http :HttpClient) { }
  saveEmployee(employee: any): Observable<any> {

    return this.http.post('http://localhost:8181/api/admin/employees', employee);
  }
  saveVendor(Vendor : any): Observable<any>
  {
    return this.http.post('http://localhost:8181/api/admin/vendors', Vendor);
  }
  getEmployees(): Observable<any> {
    return this.http.get(`http://localhost:8181/api/admin/employees`);
  }

  getVendors(): Observable<any> {
    return this.http.get(`http://localhost:8181/api/admin/vendors`);
  }

  sendEmail(employeeEmail: string, vendorEmail: string): Observable<any>
  {
    let params = new HttpParams().set('employeeEmail' ,employeeEmail).set('vendorEmail', vendorEmail);
    return this.http.post(`http://localhost:8181/api/admin/send-email`, {}, { params });
  }

}
