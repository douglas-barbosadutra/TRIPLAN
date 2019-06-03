import { User } from './User';
import {City} from './City';
export class Hotel {
    idHotel: number;
    namehotel: string;
    latitude: number;
    longitude: number;
    numerostelle: number;
    cityDTO: City;
    userDTO: User;

    // tslint:disable-next-line:max-line-length
    constructor(idHotel: number, namehotel: string, latitude: number, longitude: number, cityDTO: City, numerostelle: number, userDTO: User) {
        this.idHotel = idHotel;
        this.namehotel = namehotel;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cityDTO = this.cityDTO;
        this.numerostelle = numerostelle;
        this.userDTO = this.userDTO;
    }

}
