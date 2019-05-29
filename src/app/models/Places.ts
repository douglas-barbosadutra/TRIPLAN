
export class Places {
    idPlaces: number;
    nameplaces: string;
    latitude: number;
    longitude: number;
    type: string;
    idCity: number;

    // tslint:disable-next-line:max-line-length
    constructor(idPlaces: number, nameplaces: string, latitude: number, longitude: number, type: string, idCity: number) {
        this.idPlaces = idPlaces;
        this.nameplaces = nameplaces;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.idCity = idCity;

    }

}
