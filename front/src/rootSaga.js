import { fork } from 'redux-saga/effects'

import playersSaga from './components/playersSaga'

function* rootSaga() {
  yield [fork(playersSaga)]
}

export default rootSaga
