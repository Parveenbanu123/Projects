import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InsuranceService } from '../../services/insurance';

@Component({
  selector: 'app-my-policies',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './my-policies.html',
  styleUrls: ['./my-policies.css']
})
export class MyPolicies implements OnInit {

  policies:any[] = [];

  constructor(private service:InsuranceService,private cdr : ChangeDetectorRef){}

  ngOnInit(){
    this.service.getBookings().subscribe(res => {this.policies = res;
      this.cdr.detectChanges();
    });
  }
}
