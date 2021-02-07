
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  userList: any;

  constructor(private _httpClient: HttpClient) { }

  ngOnInit(): void {
    this._httpClient.get('http://jsonplaceholder.typicode.com/users').subscribe(result => {
      // console.log(result);
      this.userList = result;
      console.log(this.userList);
    }, errors => {
      console.log(errors);
    })
  }

}
