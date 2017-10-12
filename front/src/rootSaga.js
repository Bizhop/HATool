import { fork } from 'redux-saga/effects'

import playersSaga from './components/players/playersSaga'
import playerSaga from './components/player/playerSaga'
import importSaga from './components/import/importSaga'
import linesSaga from './components/lines/linesSaga'

function* rootSaga() {
  yield [fork(playersSaga), fork(playerSaga), fork(importSaga), fork(linesSaga)]
}

export default rootSaga
