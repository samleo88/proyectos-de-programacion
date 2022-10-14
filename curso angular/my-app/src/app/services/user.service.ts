import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../Models/usermodels';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient ) { }
  getuserName() {

    this.http.get ( 'http://localhost:53466/api/User/1212' )
    .subscribe(res => {
    console.log(res);

    });


  }

  getUsers() {

    return this.http.get ( 'http://localhost:53466/api/User/users' );
      }

  adduser( user: User ) {


    this.http.post('http://localhost:53466/api/User/adduser', user)
    .subscribe(res => {
      console.log(res);
      });

  }

}
