import { DefaultIterableDiffer } from '@angular/core';

export class Image {
    idImage: number;
    image: string;
    type: string;

    // tslint:disable-next-line:max-line-length
    constructor(idImage: number, image: string, type: string, ) {
        this.idImage = idImage;
        this.image = image;
        this.type = type;
    }

}
