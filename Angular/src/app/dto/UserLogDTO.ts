export class UserLogDTO{
    jwt: string;
    type: number;

    constructor(jwt: string, type:number){
        this.jwt = jwt;
        this.type = type;
    }
}