import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,HttpResponse} from '@angular/common/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'
import {User} from '../user/User.class'
import {Book} from '../book/Book.class'


@Injectable()
export class BackendService {

    constructor(private http: HttpClient) { }

    getUsers(): Observable<Array<User>> {
        let header = new HttpHeaders({ 'Accept': 'application/json',
            'Authorization' : 'Basic ' + btoa('seppe:password')
        });

        return this.http.get<Array<User>>(`${environment.baseUrl}/user` , { headers: header });
    }

    getAllBooks(): Observable<Array<Book>> {
        let header = new HttpHeaders({ 'Accept': 'application/json',
        'Authorization' : 'Basic ' + btoa('seppe:password')
    });

        return this.http.get<Array<Book>>(`${environment.baseUrl}/book` , { headers: header });
    }

    addUser(user : User) {
        let header = new HttpHeaders({ 'Accept': 'application/json',
        'Authorization' : 'Basic ' + btoa('seppe:password')
    });

        return this.http.post<User>(`${environment.baseUrl}/user` , user);
    }

    registerBook(book : Book){
    let header = new HttpHeaders({ 'Accept': 'application/json',
        'Authorization' : 'Basic ' + btoa('seppe:password')
    });
    return this.http.post<Book>(`${environment.baseUrl}/book` , book, { headers: header});
    }

    getBookByIsbn(isbn) {
        let header = new HttpHeaders({ 'Accept': 'application/json',
        'Authorization' : 'Basic ' + btoa('seppe:password')
    });
   
    return this.http.get<Array<Book>>(`${environment.baseUrl}/book/byisbn` , { headers: header, params: {"isbn":isbn} });
    }

    getBookByTitle(title){
        let header = new HttpHeaders({ 'Accept': 'application/json',
        'Authorization' : 'Basic ' + btoa('seppe:password')
    });
   
    return this.http.get<Array<Book>>(`${environment.baseUrl}/book/byTitle` , { headers: header, params: {"title":title} });
    }

    getBookByAuthor(author){
        let header = new HttpHeaders({ 'Accept': 'application/json',
        'Authorization' : 'Basic ' + btoa('seppe:password')
    });
   
    return this.http.get<Array<Book>>(`${environment.baseUrl}/book/byauthor` , { headers: header, params: {"author":author} });
    }
}