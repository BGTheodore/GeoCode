import React from 'react';

const Dashboard = React.lazy(() => import('./views/dashboard/Dashboard'));

const UserForm = React.lazy(() => import('./views/users/UserForm'));
const Users = React.lazy(() => import('./views/users/Users'));

const InstitutionForm = React.lazy(() => import('./views/institutions/InstitutionForm'));
const Institutions = React.lazy(() => import('./views/institutions/Institutions'));

const routes = [
  { path: '/', exact: true, name: 'Accueil' },
  { path: '/dashboard', name: 'Dashboard', component: Dashboard },

  { path: '/users/create', exact: true, name: 'Ajouter', component: UserForm },//CRAETE
  { path: '/users', exact: true,  name: 'Utilisateurs', component: Users },//READ
  { path: '/users/edit/:id', exact: true, name: 'Modifier', component: UserForm },//UPDATE

  { path: '/institutions/create', exact: true, name: 'Ajouter', component: InstitutionForm },//CRAETE
  { path: '/institutions', exact: true,  name: 'Institutions', component: Institutions },//READ
  { path: '/institutions/edit/:id', exact: true, name: 'Modifier', component: InstitutionForm },//UPDATE
];

export default routes;
