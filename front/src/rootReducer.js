import { combineReducers } from 'redux'

import playersReducer from './components/playersReducer'

const rootReducer = combineReducers({
  players: playersReducer,
})

export default rootReducer
