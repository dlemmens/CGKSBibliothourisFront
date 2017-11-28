import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './app.guard';
import { Users } from './user/users.component';
import { Books } from './book/books.component';
// import { Home } from './home/home.component';

const appRoutes: Routes = [
    // { path: 'home', component: Home },    
    { path: 'users', component: Users },
    { path: 'books', component: Books }
];

export const routing = RouterModule.forRoot(appRoutes);