import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from '../Services/auth-service.service';
import { LogservService } from '../Services/log-service.service';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  title='abc';
  
  loginform=new FormGroup({ 
       userId:new FormControl('',[Validators.required]),
       password: new FormControl("",[Validators.minLength(5),Validators.maxLength(10)])
    
      })

      get userId() {return this.loginform.get("userId")}
      get password() {return this.loginform.get("password")}

 constructor( private Auth:AuthServiceService, private r:Router,  private log:LogservService) {}

  login(){  
    const data=this.loginform.value
    this.Auth.loginData(data).subscribe((x:any)=>{alert("$$ LOGGED IN $$")
      console.log(x);
      this.Auth.loginUser(x.token,this.loginform.value.userId);

      this.log.isAuth=true;
    if(this.log.redirect!==null)
  this.r.navigate([this.log.redirect])
  else
 this.r.navigate([''])},()=>{alert(" TRY AGAIN !! ");
})}

  ngOnInit(): void {
  }

  sound()
  {
    let audio= new Audio();
    audio.src="./assets/notifi.wav";
    audio.load();
    audio.play();
  }
}
