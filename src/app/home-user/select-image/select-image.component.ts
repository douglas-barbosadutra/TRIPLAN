import { Component, OnInit } from '@angular/core';
import { Image } from '../../models/Image';
import { ImageService } from '../../services/image.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-select-image',
  templateUrl: './select-image.component.html',
  styleUrls: ['./select-image.component.css']
})
export class SelectImageComponent implements OnInit {
  imageList: Image[];
  image: Image;


  constructor(private imageService: ImageService, private router: Router) { }

  ngOnInit() {
   this.imageService.showImage().subscribe((data: any) => {

      if (data != null) {
        this.imageList = data;
      }
    });
  }

    selectImage(image: Image) {
      this.imageService.selectImage(image).subscribe((data: any) => {
        this.router.navigateByUrl('');
      });
    }
  }
