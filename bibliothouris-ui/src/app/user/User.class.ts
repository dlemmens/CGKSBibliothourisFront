export class User {
    inss: string;
    lastname: string;
    firstname: string;
    street: string;
    number: string;
    postalcode: string;
    city: string;

    constructor(   inss: string,
        lastname: string,
        firstname: string,
        street: string,
       number: string,
        postalcode: string,
        city: string){

        this.inss= inss;
        this.lastname = lastname;
        this.firstname = firstname;
        this.street = street;
        this.number = number;
        this.postalcode = postalcode;
        this.city = city;
    }
}