import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-ghus-list',
  templateUrl: './ghus-list.component.html',
  styleUrls: ['./ghus-list.component.css']
})
export class GhusListComponent implements OnInit {

  userList: User[];
  user: User;
  gestorihotel: User[];
  users: User[];

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.user = new User(0, '', '', '');
    this.showUser();

  }

    deleteUser(idUser: number) {

      this.userService.deleteUser(idUser).subscribe((data: any) => {

        this.router.navigateByUrl('hometo');
      });
    }

    showUser() {
        this.userService.showUser().subscribe(users => this.separate(users));
    }

    separate(users: User[]) {
       this.gestorihotel = new Array<User>();
       this.users = new Array<User>();
       for (const user of users) {
            if (user.userType === 'gestorehotel') {
                this.gestorihotel.push(user);
            }

            if (user.userType === 'user') {
                this.users.push(user);
            }
       }

    }

}
