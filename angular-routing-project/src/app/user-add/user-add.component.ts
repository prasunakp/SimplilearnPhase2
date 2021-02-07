import { HttpClient } from '@angular/common/http';
import { User } from './../models/user';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {

  user: User = new User();

  constructor(private _httpClient: HttpClient, private _router: Router) { }

  ngOnInit(): void {
  }

  addUser() {
    console.log(this.user);
    this._httpClient.post('http://jsonplaceholder.typicode.com/users', this.user).subscribe(result => {
      console.log('Successfully Posted User Object');
      console.log(this.user);
      this._router.navigate(['/users']);
    }, errors => {
      console.log(errors);
    })
  }

}
