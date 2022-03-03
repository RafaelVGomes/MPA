import { RoomComponent } from './components/room/room.component';
import { HomeComponent } from './components/layout/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:"", redirectTo:"home", pathMatch: "full"},
  {path: "home", component: HomeComponent},
  {path: "room", component: RoomComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
