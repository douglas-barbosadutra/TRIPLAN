export class UserDTO{
    id: number;
    username: string;
    password: string;
    type: number;
    authorities: Array<string>;
    role?: Array<string>;

}
