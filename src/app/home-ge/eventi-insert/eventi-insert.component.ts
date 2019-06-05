import { Component, OnInit } from '@angular/core';
import { Eventi } from '../../models/Eventi';
import { EventiService } from '../../services/eventi.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-eventi-insert',
  templateUrl: './eventi-insert.component.html',
  styleUrls: ['./eventi-insert.component.css']
})
export class EventiInsertComponent implements OnInit {
  public eventi: Eventi;

  constructor(private eventiService: EventiService, private router: Router) { }

  ngOnInit() {
    this.eventi = new Eventi(0, '', '', null , null );
  }

    insertEvento(f: NgForm) {

    this.eventiService.insertEvento(this.eventi).subscribe((data: any) => {
        alert('Inserimento effettuato');
        this.router.navigateByUrl('/homege');
 });
  }

}
