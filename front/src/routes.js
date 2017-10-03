import React from 'react'
import { Route, IndexRoute } from 'react-router'
import App from './containers/App'
import Players from './components/Players'

export default (
  <Route path="/" component={App}>
    <IndexRoute component={Players} />
  </Route>
)
