import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LogservService {
isAuth= false ;
redirect: string | null=null;
  constructor() { }
}
