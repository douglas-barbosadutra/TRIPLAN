
export class Hotel {
    idHotel: number;
    namehotel: string;
    latitude: number;
    longitude: number;
    id_city: number;
    numerostelle: number;
    id_user: number;

    // tslint:disable-next-line:max-line-length
    constructor(idHotel: number, namehotel: string, latitude: number, longitude: number, id_city: number, numerostelle: number, id_user: number,) {
        this.idHotel = idHotel;
        this.namehotel = namehotel;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id_city = id_city;
        this.numerostelle = numerostelle;
        this.id_user = id_user;
    }

}
