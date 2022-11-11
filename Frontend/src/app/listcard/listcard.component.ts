import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pizza } from '../Pizza/pizza';
import { AuthServiceService } from '../Services/auth-service.service';

@Component({
  selector: 'app-listcard',
  templateUrl: './listcard.component.html',
  styleUrls: ['./listcard.component.css']
})
export class ListcardComponent implements OnInit {

  constructor(private Auth: AuthServiceService ,private router: Router) { }


  @Input() public pizzaId:string= "";
  p:Pizza=new Pizza();

  ngOnInit(): void {
    this.Auth.getpizzaId(this.pizzaId).subscribe(x=>this.p=x);
  }

 

}
