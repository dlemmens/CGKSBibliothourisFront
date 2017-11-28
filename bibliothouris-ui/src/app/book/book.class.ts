export class Book {
    title: string;
    isbn: string;
    lastNameAuthor: string;
    firstNameAuthor: string;

    constructor(isbn: string, title: string, lastNameAuthor: string, firstNameAuthor: string) {
        this.isbn = isbn;
        this.title = title;
        this.lastNameAuthor = lastNameAuthor;
        this.firstNameAuthor = firstNameAuthor;
    }
}