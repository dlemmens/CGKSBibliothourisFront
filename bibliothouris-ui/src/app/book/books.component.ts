import{Component, OnInit}from '@angular/core';
import {Http, Response}from '@angular/http';

import {Book }from './Book.class'
import {BackendService}from '../backend/backend.service'



@Component({
    selector: 'books',
    templateUrl: './books.component.html'
})
export class Books implements OnInit {

    books: Array<Book> = [];
    selectedBook: Book;
    bookIsbn : string ="";
    bookTitle : string = "";
    bookAuthor: string = "";

    model = new Book("","","","");

    constructor(private backendService: BackendService) { }

    ngOnInit() {
        this.backendService.getAllBooks()
            .subscribe(books => {
                this.books = books;
            });
    }

    selectBook(book: Book, event: Event) {
        this.selectedBook = book;
        event.stopPropagation();
      }

    newBook(){
    this.backendService.registerBook(this.model)
    .subscribe();
    }

    getByIsbn(isbn){
    this.backendService.getBookByIsbn(isbn)
    .subscribe(books => {
        this.books = books;
    })
    }

    getByTitle(title){
        this.backendService.getBookByTitle(title)
        .subscribe(books => {
            this.books = books;
        })
    }

    getByAuthor(author){
        this.backendService.getBookByAuthor(author)
        .subscribe(books => {
            this.books = books;
        })
    }

}