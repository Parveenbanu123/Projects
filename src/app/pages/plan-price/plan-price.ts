import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { InsuranceService } from '../../services/insurance';

@Component({
  selector: 'app-plan-price',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './plan-price.html',
  styleUrls: ['./plan-price.css']
})
export class PlanPrice implements OnInit {

  plan:any;
  age:number = 0;
  income:number = 0;
  healthIssue:string = '';
  premium:number = 0;
  isCalculated:boolean = false;

  constructor(
    private route:ActivatedRoute,
    private service:InsuranceService,
    private router:Router
  ){}

  ngOnInit(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.service.getPlanById(id).subscribe(res=>{
      this.plan = res[0];
    });
  }

  calculate(){
    this.premium = this.plan.baseAmt;

    if(this.age > 40) this.premium += 1000;
    if(this.income > 500000) this.premium += 500;
    if(this.healthIssue === 'yes') this.premium += 1500;

    this.isCalculated = true;
  }

  buyPlan(){
    this.router.navigate(['/buy', this.plan.planId], {
      state: { premium: this.premium }
    });
  }

  isValid(){
    return this.age > 0 && this.income > 0;
  }
}
