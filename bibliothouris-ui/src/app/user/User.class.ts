export class User {
    inss: string;
    lastName: string;
    firstname: string;
    street: string;
    housenumber: string;
    postalCode: string;
    city: string;

    constructor(   inss: string,
        lastName: string,
        firstname: string,
        street: string,
        housenumber: string,
        postalCode: string,
        city: string){

        this.inss= inss;
        this.lastName = lastName;
        this.firstname = firstname;
        this.street = street;
        this.housenumber = housenumber;
        this.postalCode = postalCode;
        this.city = city;
    }
}