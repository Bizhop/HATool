import { combineReducers } from 'redux'
import { reducer as formReducer } from 'redux-form'

import playersReducer from './components/players/playersReducer'
import playerReducer from './components/player/playerReducer'
import importReducer from './components/import/importReducer'

const rootReducer = combineReducers({
  form: formReducer,
  players: playersReducer,
  player: playerReducer,
  import: importReducer,
})

export default rootReducer
