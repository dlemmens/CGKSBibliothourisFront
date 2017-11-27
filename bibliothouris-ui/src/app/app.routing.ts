import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './app.guard';
import { Users } from './user/users.component';
// import { Books } from './user/users.component';

const appRoutes: Routes = [
    { path: 'users', component: Users }
    // { path: 'books', component: Books }
];

export const routing = RouterModule.forRoot(appRoutes);