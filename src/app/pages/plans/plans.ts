import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { InsuranceService } from '../../services/insurance';

@Component({
  selector: 'app-plans',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './plans.html',
  styleUrls: ['./plans.css']
})
export class Plans implements OnInit {

  plans:any[] = [];

  constructor(private service:InsuranceService, private router:Router , private cdr : ChangeDetectorRef) {}

  ngOnInit(){
    this.service.getPlans().subscribe(res => {this.plans = res;
      this.cdr.detectChanges();

    }
      
    );
  }

  goToPrice(id:number){
    this.router.navigate(['/plan-price', id]);
  }
}
