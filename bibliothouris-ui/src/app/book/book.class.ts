export class Book {
    title: string;
    isbn: string;
    lastName: string;
    firstName: string;

    constructor(isbn: string, title: string, lastName: string, firstName: string) {
        this.isbn = isbn;
        this.title = title;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}