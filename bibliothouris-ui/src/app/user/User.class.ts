export class User {
    inss: string;
    lastName: string;
    firstName: string;
    street: string;
    houseNumber: string;
    postalCode: string;
    city: string;
    password: string;

    constructor(   inss: string,
        lastName: string,
        firstName: string,
        street: string,
        houseNumber: string,
        postalCode: string,
        city: string,
        password: string){

        this.inss= inss;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city
        this.password = password;
    }
}