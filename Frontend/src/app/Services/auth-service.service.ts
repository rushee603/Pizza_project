import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pizza } from '../Pizza/pizza';
import {  Pizzalist } from '../Pizza/pizzalist';


@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http:HttpClient) { }
  register="http://localhost:9900/pizza/register"

  login=" http://localhost:9900/customer//login"

  details=" http://localhost:9900/pizza/showAll"

  list="http://localhost:9900/pizza/pizzalist"

  getPizza="http://localhost:9900/pizza/pizzaId/"

  url2="http://localhost:9900/pizza/getpizzalist/"

  registerData(data:any) { return this.http.post(this.register,data)}

  loginData(data:any) {return this.http.post(this.login,data) }

  listshow(data:any) {
    console.log(data);
    return this.http.post(this.list,data)}

  loginUser(token:any, userId: any){
    localStorage.setItem("token",token);
    localStorage.setItem("userId", userId);
    return true;
  }

  getAllPizza() {return this.http.get<Pizza[]>(this.details)}

  getpizzaId(pizzaId:any) {return this.http.get<Pizza>(this.getPizza+pizzaId)}


  getPizzalistByUserId(userId:any)
    {
      return this.http.get<Pizzalist>(this.url2+userId);
    }
}
