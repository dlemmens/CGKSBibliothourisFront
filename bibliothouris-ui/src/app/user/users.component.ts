import { Component, OnInit } from '@angular/core';

import { User } from './User.class'
import { BackendService } from '../backend/backend.service'
import { FormsModule } from '@angular/forms';


@Component({
    selector: 'users',
    templateUrl: './users.component.html'
})
export class Users implements OnInit {

    users: Array<User> = [];

    constructor(private backendService: BackendService) { }

    ngOnInit() {
        this.backendService.getUsers()
            .subscribe(users => {
                this.users = users;
            });
    }



    // addUser(){

    // }

}