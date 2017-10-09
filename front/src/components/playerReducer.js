import { FETCH_PLAYER_REQUEST, FETCH_PLAYER_SUCCESS, FETCH_PLAYER_FAILURE } from './playerActions'

const initialState = {}

const playersReducer = (state = initialState, action) => {
  switch (action.type) {
    case FETCH_PLAYER_REQUEST:
      return {
        ...state,
      }
    case FETCH_PLAYER_FAILURE:
      return {
        ...state,
      }
    case FETCH_PLAYER_SUCCESS:
      return {
        ...state,
        player: action.player,
      }
    default:
      return state
  }
}

export default playersReducer
