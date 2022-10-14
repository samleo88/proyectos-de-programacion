import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../Models/usermodels';
import {FormControl, FormGroup, FormBuilder, FormArray, FormArrayName } from '@angular/forms';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  miformulario: FormGroup;
  flag = false;
  users: any[] = [];
  constructor(private userService: UserService, private fb: FormBuilder) {

   }

  ngOnInit() {

  this.miformulario = this.fb.group({
    email: [''],
    nombre: [''],
    apellido: [''],
    date: [''],
    telefonos: this.fb.array([this.fb.group({telefono: ['']})])
  });
  }

  onSubmit(FormValue: any) {

    const user = new User();

    user.nombre = FormValue.nombre;
    user.apellido = FormValue.apellido;
    user.email = FormValue.email;
    user.date = new Date (FormValue.date.year, FormValue.date.month, FormValue.date.day);
    user.telefonos = FormValue.telefonos;

    this.userService.adduser(user);
    this.flag = !this.flag;
    this.userService.getUsers()
    .subscribe((resp: any ) => {
      this.users = resp;

    });
  }
  get getTelefonos() {
    return this.miformulario.get('telefonos') as FormArray;
  }


  addTelefono() {
    const control = this.miformulario.controls[('telefonos')] as FormArray;
    control.push(this.fb.group({telefonos: []}));

  }

  removeTelefono(index: number) {

    const control = this.miformulario.controls[('telefonos')] as FormArray;
    control.removeAt(index);

  }

}
