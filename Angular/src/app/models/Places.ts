import { City } from './City';

export class Places {
    idPlaces: number;
    nameplaces: string;
    latitude: number;
    longitude: number;
    type: string;
    cityDTO: City;

    // tslint:disable-next-line:max-line-length
    constructor(idPlaces: number, nameplaces: string, latitude: number, longitude: number, type: string, cityDTO: City) {
        this.idPlaces = idPlaces;
        this.nameplaces = nameplaces;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.cityDTO = this.cityDTO;

    }

}
