import { ServiceService } from './../../service.service';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {
 
  employeeForm : FormGroup;
  constructor(private fb: FormBuilder, private service: ServiceService)
  {
    this.employeeForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      name: ['', Validators.required],
      designation: ['', Validators.required],
      ctc: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.employeeForm.valid) {
      this.service.saveEmployee(this.employeeForm.value).subscribe(response => {
        console.log('Employee created:', response);
        this.employeeForm.reset();
      });
    }
  }
}
