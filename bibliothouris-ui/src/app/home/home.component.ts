import { Component, OnInit} from '@angular/core';
import { FormsModule }   from '@angular/forms';


import { User } from '../user/User.class'
import { BackendService } from '../backend/backend.service'
import { Userlogindata } from '../user/Userlogindata.class';
import { HttpResponse } from '@angular/common/http/src/response';

@Component({
    selector: 'home',
    templateUrl: './home.component.html'
})
export class Home {

    user = new User("", "", "", "", "", "", "","");
    userlogindata = new Userlogindata("","");
    isLoggedIn: Boolean;

    constructor(private backendService: BackendService) { }
    
    newUser() {
        this.backendService.addUser(this.user)
        .subscribe();
    }

    login() {
        this.backendService.validateLogin(this.userlogindata)
        .subscribe(response => {
            console.log(response);
            this.isLoggedIn = response.status === 200;
        });
    }

}