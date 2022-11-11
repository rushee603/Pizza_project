import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LogservService } from './Services/log-service.service';

@Injectable({
  providedIn: 'root'
})
export class LogguardGuard implements CanActivate {
  constructor(private log:LogservService, private r:Router){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.log.isAuth){
        return true;
       }
       else{
        this.r.navigateByUrl("login")
        return false;
       }
  }
  
}
