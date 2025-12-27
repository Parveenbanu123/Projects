import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { InsuranceService } from '../../services/insurance';
 
@Component({
  selector: 'app-buy-plan',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './buy-plan.html',
  styleUrls: ['./buy-plan.css']
})
export class BuyPlan implements OnInit {
 
  plan:any;
  premium:number = 0;
 
  user = {
    name:'',
    city:'',
    phone:'',
    email:'',
    age: 0,
    paymentMode:'',
    cardNumber:'',
    paymentFreq:''
  };
 
  constructor(
    private route:ActivatedRoute,
    private service:InsuranceService,
    private router:Router
  ){}
 
  ngOnInit(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
 
    this.service.getPlanById(id).subscribe(res => {
      this.plan = res[0];
    });
 
    // ✔️ Get premium safely
    const nav = this.router.getCurrentNavigation();
    this.premium = nav?.extras.state?.['premium'] || history.state.premium || 0;
  }
 
  isValid(){
    return this.user.name.trim() !== '' &&
      this.user.city.trim() !== '' &&
      this.user.phone.toString().length === 10 &&
      this.user.cardNumber.toString().length === 16 &&
      this.user.email.includes('@') &&
      this.user.age > 0 &&
      this.user.paymentMode !== '' &&
      this.user.paymentFreq !== '';
  }
 
  submit(){
    const booking = {
      ...this.user,
      planId: this.plan.id,
      planName: this.plan.name,
      premiumAmt: this.premium,
      validity: "2025-12-11"
    };
 
    this.service.saveBooking(booking).subscribe(()=>{
      alert("🎉 Insurance Plan Purchased Successfully!");
      this.router.navigate(['/my-policies']);
    });
  }
}
 