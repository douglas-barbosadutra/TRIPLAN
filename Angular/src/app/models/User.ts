
export class User {
    idUser: number;
    username: string;
    password: string;
    userType: string;


    // tslint:disable-next-line:max-line-length
    constructor(idUser: number, username: string, password: string, userType: string, ) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

}
