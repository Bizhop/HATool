import { call, put, takeEvery } from 'redux-saga/effects'

import Api from './Api'
import { receivePlayers, playersFetchError, FETCH_PLAYERS_REQUEST } from './playersActions'

function* fetchPlayers() {
  try {
    const players = yield call(Api.get, 'api/players', {})
    yield put(receivePlayers(players))
  } catch (e) {
    yield put(playersFetchError(e))
  }
}

function* playersSaga() {
  yield takeEvery(FETCH_PLAYERS_REQUEST, fetchPlayers)
}

export default playersSaga
