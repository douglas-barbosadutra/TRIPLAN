import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-toge-list',
  templateUrl: './toge-list.component.html',
  styleUrls: ['./toge-list.component.css']
})
export class TogeListComponent implements OnInit {

  userList: User[];
  user: User;
  touroperators: User[];
  gestoreeventi: User[];

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.showUser();

  }

    deleteUser(idUser: number) {
      this.userService.deleteUser(idUser).subscribe((data: any) => {
      this.router.navigateByUrl('homesu');
      });
    }

    showUser() {
        this.userService.showUser().subscribe(users => this.separate(users));
    }

    separate(users: User[]) {
       this.touroperators = new Array<User>();
       this.gestoreeventi = new Array<User>();
       for (const user of users) {
            if (user.userType === 'touroperator') {
                this.touroperators.push(user);
            }

            if (user.userType === 'gestoreeventi') {
                this.gestoreeventi.push(user);
            }
       }

    }
}
