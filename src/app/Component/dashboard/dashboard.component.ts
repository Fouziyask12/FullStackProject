import { ServiceService } from './../../service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {

  employees: any[] = [];
  vendors: any[] = [];
  selectedEmployeeEmail: string = '';
  selectedVendorEmail: string = '';

  constructor(private service: ServiceService) { }

  ngOnInit(): void {
    this.loadEmployees();
    this.loadVendors();
  }

  loadEmployees() {
    this.service.getEmployees().subscribe(data => {
      this.employees = data;
    });
  }

  loadVendors() {
    this.service.getVendors().subscribe(data => {
      this.vendors = data;
    });
  }

  onSendEmail() {
    if (this.selectedEmployeeEmail && this.selectedVendorEmail) {
      this.service.sendEmail(this.selectedEmployeeEmail, this.selectedVendorEmail).subscribe(() => {
        alert('Email sent successfully!');
      });
    } else {
      alert('Please select both an employee and a vendor.');
    }
  }

}
