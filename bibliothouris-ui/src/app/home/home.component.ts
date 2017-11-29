import { Component, OnInit} from '@angular/core';
import { FormsModule }   from '@angular/forms';


import { User } from '../user/User.class'
import { BackendService } from '../backend/backend.service'

@Component({
    selector: 'home',
    templateUrl: './home.component.html'
})
export class Home {


    model = new User("", "", "", "", "", "", "","");
    constructor(private backendService: BackendService) { }
    
    newUser() {
        this.backendService.addUser(this.model)
        .subscribe();
    }

    // login() {
    //     this.authenticationService.login(this.model.inss, this.model.password)
    //         .subscribe(
    //             data => {
    //                 this.router.navigate([this.returnUrl]);
    //             },
    //             error => {
    //                 this.alertService.error(error);
    //             });
    // }
    
}