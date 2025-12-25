import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { About } from './pages/about/about';
import { Plans } from './pages/plans/plans';
import { PlanPrice } from './pages/plan-price/plan-price';
import { BuyPlan } from './pages/buy-plan/buy-plan';
import { MyPolicies } from './pages/my-policies/my-policies';

export const routes: Routes = [
  { path: '', redirectTo:'home', pathMatch:'full' },
  { path: 'home', component: Home },
  { path: 'about', component: About },
  { path: 'plans', component: Plans },
  { path: 'plan-price/:id', component: PlanPrice },
  { path: 'buy/:id', component: BuyPlan },
  { path: 'my-policies', component: MyPolicies }
];
