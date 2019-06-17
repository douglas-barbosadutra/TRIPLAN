export interface IUser {
    id?: number;
    username?: string;
    password?: string;
    usertype?: string;
}

export class User implements IUser {
    constructor(public id?: number, public username?: string, public password?: string, public usertype?: string) {}
}
