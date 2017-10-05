import React from 'react'
import R from 'ramda'
import { connect } from 'react-redux'

import { fetchPlayers } from './playersActions'

const Player = props => (
  <tr>
    <td>{props.player.name}</td>
    <td>{props.player.latestData.age}</td>
    <td>{props.player.latestData.quality}</td>
    <td>{props.player.latestData.potential}</td>
    <td>{props.player.latestData.goalie}</td>
    <td>{props.player.latestData.defence}</td>
    <td>{props.player.latestData.attack}</td>
    <td>{props.player.latestData.shooting}</td>
    <td>{props.player.latestData.passing}</td>
    <td>{props.player.latestData.speed}</td>
    <td>{props.player.latestData.strength}</td>
    <td>{props.player.latestData.selfControl}</td>
    <td>{props.player.latestData.form}</td>
    <td>{props.player.latestData.experience}</td>
    <td>{props.player.latestData.abilityIndex}</td>
    <td>{props.player.latestData.weeks}</td>
  </tr>
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
            <th>Nimi</th>
            <th>Ikä</th>
            <th>Lah</th>
            <th>Pot</th>
            <th>MV</th>
            <th>Puo</th>
            <th>Hyö</th>
            <th>Lau</th>
            <th>Syö</th>
            <th>Nop</th>
            <th>Voi</th>
            <th>Ihi</th>
            <th>Kun</th>
            <th>Kok</th>
            <th>TI</th>
            <th>Viikot</th>
          </tr>
          {props.players.map(p => <Player key={p.id} player={p} />)}
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
})

export default connect(mapStateToProps, mapDispatchToProps)(PlayersContainer)
