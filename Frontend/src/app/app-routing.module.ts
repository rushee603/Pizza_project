import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DailogboxComponent } from './dailogbox/dailogbox.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeaderComponent } from './header/header.component';
import { LogguardGuard } from './logguard.guard';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  
  {path:'login',
component:LoginComponent,

},
{
path:'registation',
component:RegisterComponent,

},
{path:'login/registation',
component:RegisterComponent,

},
{path:'header',
component:HeaderComponent,
},
{
  path:"dialog",
  component:DailogboxComponent,

},
{
  path:"",
  component:DashboardComponent,
  canActivate:[LogguardGuard]
},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
