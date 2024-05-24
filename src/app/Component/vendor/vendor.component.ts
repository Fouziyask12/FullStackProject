import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServiceService } from '../../service.service';

@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrl: './vendor.component.css'
})
export class VendorComponent {

  vendorForm: FormGroup;

  constructor(private fb: FormBuilder, private service: ServiceService) {
    this.vendorForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      name: ['', Validators.required],
      upi: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.vendorForm.valid) {
      this.service.saveVendor(this.vendorForm.value).subscribe(response => {
        console.log('Vendor created:', response);
        this.vendorForm.reset();
      });
    }
  }

}
