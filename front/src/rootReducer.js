import { combineReducers } from 'redux'
import { reducer as formReducer } from 'redux-form'

import playersReducer from './components/playersReducer'
import playerReducer from './components/playerReducer'

const rootReducer = combineReducers({
  form: formReducer,
  players: playersReducer,
  player: playerReducer,
})

export default rootReducer
