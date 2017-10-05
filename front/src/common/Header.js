import React from 'react'
import { NavLink } from 'react-router-dom'

const Header = () => (
  <div className="text-center">
    <nav className="navbar navbar-default">
      <NavLink to="/" className="nav-link nav-item" activeClassName="active">
        Players
      </NavLink>
      {' | '}
      <NavLink to="/import" className="nav-link nav-item" activeClassName="active">
        Import
      </NavLink>
    </nav>
  </div>
)

export default Header
