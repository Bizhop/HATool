import React from 'react'
import { NavLink } from 'react-router-dom'

const Header = () => (
  <div className="text-center">
    <nav className="navbar navbar-default">
      <NavLink to="/players" className="nav-link nav-item" activeClassName="active">
        Pelaajat
      </NavLink>
      {' | '}
      <NavLink to="/import" className="nav-link nav-item" activeClassName="active">
        Tuonti
      </NavLink>
    </nav>
  </div>
)

export default Header
