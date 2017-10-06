import React from 'react'
import R from 'ramda'
import { connect } from 'react-redux'

import { fetchPlayers } from './playersActions'

const Player = props => {
  const player = props.player
  return (
    <tr>
      <td>{player.name}</td>
      <td>{player.age}</td>
      <td>{player.quality}</td>
      <td>{player.potential}</td>
      <td>{player.goalie}</td>
      <td>{player.defence}</td>
      <td>{player.attack}</td>
      <td>{player.shooting}</td>
      <td>{player.passing}</td>
      <td>{player.speed}</td>
      <td>{player.strength}</td>
      <td>{player.selfControl}</td>
      <td>{player.form}</td>
      <td>{player.experience}</td>
      <td>{player.abilityIndex}</td>
      <td>{player.weeks}</td>
      <td>{player.growthPotential}</td>
    </tr>
  )
}

const ThWithButton = props => (
  <th>
    <button
      className="btn btn-link"
      onClick={() =>
        props.updatePlayers({
          sort: props.sort,
        })}
    >
      {props.label}
    </button>
  </th>
)

const PlayersContainer = props => (
  <div>
    <div className="jumbotron center">
      <h1 className="lead">Players</h1>
    </div>
    <div className="container">
      <table className="table table-responsive table-borderless mb-5">
        <tbody>
          <tr>
            <ThWithButton updatePlayers={props.updatePlayers} sort="name,asc" label="Nimi" />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.age,asc"
              label="Ikä"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.quality,desc"
              label="Lah"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.potential,desc"
              label="Pot"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.goalie,desc"
              label="MV"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.defence,desc"
              label="Puo"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.attack,desc"
              label="Hyö"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.shooting,desc"
              label="Lau"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.passing,desc"
              label="Syö"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.speed,desc"
              label="Nop"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.strength,desc"
              label="Voi"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.selfControl,desc"
              label="Ihi"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.form,desc"
              label="Kun"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.experience,desc"
              label="Kok"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.abilityIndex,desc"
              label="TI"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.weeks,desc"
              label="Viikot"
            />
            <ThWithButton
              updatePlayers={props.updatePlayers}
              sort="latestData.growthPotential,desc"
              label="Kasvunvara"
            />
          </tr>
          {props.players.map(p => <Player key={p.name} player={p} />)}
        </tbody>
      </table>
    </div>
  </div>
)

const mapStateToProps = state => ({
  players: R.pathOr([], ['players', 'players'], state),
})

const mapDispatchToProps = dispatch => ({
  getPlayers: dispatch(fetchPlayers()),
  updatePlayers: params => dispatch(fetchPlayers(params)),
})

export default connect(mapStateToProps, mapDispatchToProps)(PlayersContainer)
