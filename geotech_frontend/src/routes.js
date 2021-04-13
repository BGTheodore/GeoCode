import React from 'react';

const Dashboard = React.lazy(() => import('./views/dashboard/Dashboard'));

const UserForm = React.lazy(() => import('./views/users/UserForm'));
const Users = React.lazy(() => import('./views/users/Users'));

const routes = [
  { path: '/', exact: true, name: 'Home' },
  { path: '/dashboard', name: 'Dashboard', component: Dashboard },

  { path: '/users/create', exact: true, name: 'Ajouter', component: UserForm },//CRAETE
  { path: '/users', exact: true,  name: 'Utilisateurs', component: Users },//READ
  { path: '/users/edit/:id', exact: true, name: 'Modifier', component: UserForm }//UPDATE
];

export default routes;