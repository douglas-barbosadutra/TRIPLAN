import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  userList: User[];
  user: User;
  touroperators: User[];
  users: User[];

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.showUser();

  }

    deleteUser(idUser: number) {

      this.userService.deleteUser(idUser).subscribe((data: any) => {

        if (data) {
          alert('Cancellazione effettuata');
        } else {
          alert('Cancellazione fallita');
        }

        this.router.navigateByUrl('homesu');
      });
    }

    showUser() {
        this.userService.showUser().subscribe(users => this.separate(users));
    }

    separate(users: User[]) {
       this.touroperators = new Array<User>();
       this.users = new Array<User>();
       for (const user of users) {
            if (user.userType === 'touroperator') {
                this.touroperators.push(user);
            }
            if (user.userType === 'user') {
                this.users.push(user);
            }
       }

    }
}
