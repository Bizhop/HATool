import React from 'react'
import { connect } from 'react-redux'
import { Route, Redirect, Switch, withRouter } from 'react-router-dom'

import Header from '../common/Header'
import PlayersContainer from './PlayersContainer'

const NotFound = () => (
  <div className="container">
    <div className="jumbotron">
      <h1>Page not Found 404!</h1>
    </div>
  </div>
)

const Routes = () => (
  <div className="container pt-5">
    <Switch>
      <Route exact path="/" component={PlayersContainer} />
      <Route component={NotFound} />
    </Switch>
  </div>
)

const App = props => (
  <div className="app">
    <Header />
    <Routes />
  </div>
)

export default App
