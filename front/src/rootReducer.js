import { combineReducers } from 'redux'
import { reducer as formReducer } from 'redux-form'

import playersReducer from './components/players/playersReducer'
import playerReducer from './components/player/playerReducer'
import importReducer from './components/import/importReducer'
import linesReducer from './components/lines/linesReducer'

const rootReducer = combineReducers({
  form: formReducer,
  players: playersReducer,
  player: playerReducer,
  import: importReducer,
  lines: linesReducer,
})

export default rootReducer
