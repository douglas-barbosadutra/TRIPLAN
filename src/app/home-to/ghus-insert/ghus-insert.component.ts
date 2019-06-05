import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../models/User';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-ghus-insert',
  templateUrl: './ghus-insert.component.html',
  styleUrls: ['./ghus-insert.component.css']
})
export class GhusInsertComponent implements OnInit {
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

      this.router.navigateByUrl('/hometo');
    });
  }

}
