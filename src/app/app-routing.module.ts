import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { GetFlightComponent } from './get-flight/get-flight.component';
import { UpdateDetailsComponent } from './update-details/update-details.component';
import { BookComponent } from './book/book.component';
import { PaymentComponent } from './payment/payment.component';
import { authGuard } from './_helpers/auth.guard';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  {
    path: 'flights', component: GetFlightComponent, canActivate: [authGuard],
    data: { roles: ['admin'] }
  },
  {
    path: 'admin', component: BoardAdminComponent, canActivate: [authGuard],
    data: { roles: ['admin'] }
  },
  {
    path: 'update-details/:id', component: UpdateDetailsComponent, canActivate: [authGuard],
    data: { roles: ['admin'] }
  },
  { path: 'book/:id/:date/:price', component: BookComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'payment', component: PaymentComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
