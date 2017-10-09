import R from 'ramda'
import { call, put, takeEvery } from 'redux-saga/effects'

import Api from './Api'
import { receivePlayer, playerFetchError, FETCH_PLAYER_REQUEST } from './playerActions'

function* fetchPlayer(action) {
  try {
    const player = yield call(Api.get, `api/players/${action.id}`, {
      params: {
        size: 100,
        sort: R.path(['params', 'sort'], action),
      },
    })
    yield put(receivePlayer(player))
  } catch (e) {
    yield put(playerFetchError(e))
  }
}

function* playerSaga() {
  yield takeEvery(FETCH_PLAYER_REQUEST, fetchPlayer)
}

export default playerSaga
