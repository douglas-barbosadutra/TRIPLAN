import { Component, OnInit } from '@angular/core';
import { Eventi } from '../../models/Eventi';
import { EventiService } from '../../services/eventi.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-eventi-list',
  templateUrl: './eventi-list.component.html',
  styleUrls: ['./eventi-list.component.css']
})
export class EventiListComponent implements OnInit {
  eventiList: Eventi[];
  eventi: Eventi;


  constructor(private eventiService: EventiService, private router: Router) { }

  ngOnInit() {
   this.eventiService.showEventi().subscribe((data: any) => {

      if ( data != null) {
        this.eventiList = data;
      }
   })
 }

    deleteEvento(idEvento: number) {
      this.eventiService.deleteEvento(idEvento).subscribe((data: any) => {
        this.router.navigateByUrl('homege');
      });
    }
 }
