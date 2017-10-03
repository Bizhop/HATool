import React from 'react'
import { Link, IndexLink } from 'react-router'

const Header = () => (
  <div className="text-center">
    <nav className="navbar navbar-default">
      <IndexLink to="/" activeClassName="active">
        Players
      </IndexLink>
      {' | '}
      <Link to="import" activeClassName="active">
        Import
      </Link>
    </nav>
  </div>
)

export default Header
