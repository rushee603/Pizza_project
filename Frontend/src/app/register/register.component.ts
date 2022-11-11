import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from '../Services/auth-service.service';
import { LogservService } from '../Services/log-service.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit { 

  registration:FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required,Validators.pattern("^[a-zA-Z0-9_]+[@][a-z]+[.][a-z]+$")]),
    userId: new FormControl('', [Validators.required]),
    password: new FormControl('',[Validators.minLength(5),Validators.maxLength(10)]),
    cpassword: new FormControl('',[Validators.minLength(5),Validators.maxLength(10)]),
    address: new FormControl(""),
    phoneNumber: new FormControl("", [Validators.required, Validators.pattern("[1-9][0-9]{9}")])
  })

  get email() {return this.registration.get("email")}
  get password() {return this.registration.get("password")}
  get userId() {return this.registration.get("userId")}
  get address() {return this.registration.get("address")}
  get phoneNumber() {return this.registration.get("phoneNumber")}

  constructor(private auth:AuthServiceService, private route:Router ,private log:LogservService) { }
 
  submit() { const data=this.registration.value
    this.auth.registerData(data).subscribe(x=>alert("--->> REGISTERED <<--- "))
    console.log(data);
    
    this.log.isAuth=true;
    if(this.log.redirect!==null)
  this.route.navigate([this.log.redirect])
  else
 this.route.navigate(['login'])
  }

ngOnInit(): void {}
}
