import { combineReducers } from 'redux'

import playersReducer from './components/playersReducer'
import playerReducer from './components/playerReducer'

const rootReducer = combineReducers({
  players: playersReducer,
  player: playerReducer,
})

export default rootReducer
