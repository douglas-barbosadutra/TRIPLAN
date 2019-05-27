import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../models/User';
import {UserService} from '../../services/user.service';


@Component({
  selector: 'app-toge-insert',
  templateUrl: './toge-insert.component.html',
  styleUrls: ['./toge-insert.component.css']
})
export class TogeInsertComponent implements OnInit {
  public user: User;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.user = new User(0, '', '', '');
  }

    insertUser(f: NgForm) {

    this.userService.insertUser(this.user).subscribe((data: any) => {

      if (data != null) {
        alert('Inserimento effettuato');
      } else {
        alert('Inserimento fallito');
      }

      this.router.navigateByUrl('/homesu');
    });
  }

}
