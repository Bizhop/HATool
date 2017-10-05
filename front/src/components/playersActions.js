export const FETCH_PLAYERS_REQUEST = 'FETCH_PLAYERS_REQUEST'
export const FETCH_PLAYERS_SUCCESS = 'FETCH_PLAYERS_SUCCESS'
export const FETCH_PLAYERS_FAILURE = 'FETCH_PLAYERS_FAILURE'

export const fetchPlayers = () => ({
  type: FETCH_PLAYERS_REQUEST,
})

export const receivePlayers = players => ({
  type: FETCH_PLAYERS_SUCCESS,
  players,
})

export const playersFetchError = error => ({
  type: FETCH_PLAYERS_FAILURE,
  players: [],
  error,
})
