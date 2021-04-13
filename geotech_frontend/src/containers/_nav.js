import React from 'react'
import CIcon from '@coreui/icons-react'

const _nav =  [
  {
    _tag: 'CSidebarNavItem',
    name: 'Dashboard',
    to: '/dashboard',
    icon: <CIcon name="cil-speedometer" customClasses="c-sidebar-nav-icon"/>,
  },
  {
    _tag: 'CSidebarNavTitle',
    _children: ['Menu']
  },
  {
    _tag: 'CSidebarNavItem',
    name: 'Utilisateurs',
    to: '/users',
    icon: 'cil-user',
  },
  {
    _tag: 'CSidebarNavItem',
    name: 'Institutions',
    to: '/users',
    icon: 'cil-home',
  },
  {
    _tag: 'CSidebarNavDropdown',
    name: 'Essais',
    route: '/base',
    icon: 'cil-puzzle',
    _children: [
      {
        _tag: 'CSidebarNavItem',
        name: 'Essais',
        to: '/base/breadcrumbs',
      },
      {
        _tag: 'CSidebarNavItem',
        name: 'Types d\'essai',
        to: '/base/cards',
      },
    
    ],
  },
  
]

export default _nav