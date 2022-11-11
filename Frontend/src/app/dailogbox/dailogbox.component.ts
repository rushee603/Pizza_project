import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { AuthServiceService } from '../Services/auth-service.service';

@Component({
  selector: 'app-dailogbox',
  templateUrl: './dailogbox.component.html',
  styleUrls: ['./dailogbox.component.css']
})
export class DailogboxComponent implements OnInit {

  constructor(private Auth: AuthServiceService ){}
  pizzalist:string[]=[];

  ngOnInit(): void {
    this.Auth.getPizzalistByUserId(localStorage.getItem('userId')).subscribe(x=>{
       this.pizzalist=x.pizzaId;
    })
  }

  Placeorder(){
    alert(" !! ORDER PLACED SUCCESSULLY !!");
  }
}
