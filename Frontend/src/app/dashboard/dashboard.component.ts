import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { AuthServiceService } from '../Services/auth-service.service';
import { Pizza } from '../Pizza/pizza';
import { PizzaDTO } from '../Pizza/pizza-dto';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  constructor(private service : AuthServiceService) {}

  ngOnInit(){
    this.service.getAllPizza().subscribe(x=>
      {
        this.pizza=x;
        console.log(this.pizza)
      })
  }
  
 pizza:Pizza[]=[];

  getPizza(){} 
  pizza1:PizzaDTO=new PizzaDTO();


  save(x:any){
    this.pizza1.userId=localStorage.getItem('userId')!;
    this.pizza1.pizzaId=x.pizzaId;
    this.service.listshow(this.pizza1).subscribe(x=>{alert(" ADDED  IN YOUR ORDERLIST !! ")

    })
  }
}
