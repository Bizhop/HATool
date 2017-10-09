import { fork } from 'redux-saga/effects'

import playersSaga from './components/playersSaga'
import playerSaga from './components/playerSaga'

function* rootSaga() {
  yield [fork(playersSaga), fork(playerSaga)]
}

export default rootSaga
