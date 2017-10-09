import React from 'react'
import { Route, Switch } from 'react-router-dom'

import Header from '../common/Header'
import PlayersContainer from './PlayersContainer'
import PlayerContainer from './PlayerContainer'

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
      <Route exact path="/players" component={PlayersContainer} />
      <Route exact path="/players/:id" component={PlayerContainer} />
      <Route component={NotFound} />
    </Switch>
  </div>
)

const App = () => (
  <div className="app">
    <Header />
    <Routes />
  </div>
)

export default App
