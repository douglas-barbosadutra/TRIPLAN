import { City } from './City';
import { User } from './User';
export class Eventi {
    idEvento: number;
    nameevento: string;
    meseevento: string;
    cityDTO: City;
    userDTO: User;

    // tslint:disable-next-line:max-line-length
    constructor(idEvento: number, nameevento: string, meseevento: string, cityDTO: City,  userDTO: User) {
        this.idEvento = idEvento;
        this.nameevento = nameevento;
        this.meseevento = meseevento;
        this.cityDTO = this.cityDTO;
        this.userDTO = this.userDTO ;
    }

}
