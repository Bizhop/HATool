import React from 'react'
import { NavLink } from 'react-router-dom'

const Header = () => (
  <div>
    <nav className="navbar navbar-default">
      <div className="container">
        <NavLink to="/" className="nav-link nav-item" activeClassName="active">
          Etusivu
        </NavLink>
        {' | '}
        <NavLink to="/players" className="nav-link nav-item" activeClassName="active">
          Pelaajat
        </NavLink>
        {' | '}
        <NavLink to="/import" className="nav-link nav-item" activeClassName="active">
          Tuonti
        </NavLink>
      </div>
    </nav>
  </div>
)

export default Header
