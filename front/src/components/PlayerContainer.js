import React from 'react'
import R from 'ramda'
import { connect } from 'react-redux'

import { fetchPlayer } from './playerActions'

const Data = props => {
  const data = props.data
  return (
    <tr>
      <td>{data.createdAt}</td>
      <td>{data.age}</td>
      <td>{data.quality}</td>
      <td>{data.potential}</td>
      <td>{data.goalie}</td>
      <td>{data.defence}</td>
      <td>{data.attack}</td>
      <td>{data.shooting}</td>
      <td>{data.passing}</td>
      <td>{data.speed}</td>
      <td>{data.strength}</td>
      <td>{data.selfControl}</td>
      <td>{data.form}</td>
      <td>{data.experience}</td>
      <td>{data.abilityIndex}</td>
      <td>{data.weeks}</td>
      <td>{data.growthPotential}</td>
    </tr>
  )
}

const PlayerContainer = props =>
  props.player ? (
    <div className="container">
      <div className="row">
        <div className="col-md-2">Player</div>
        <div className="col-md-10">{props.player.name}</div>
      </div>
      <div className="row">
        <div className="col-md-2">Position</div>
        <div className="col-md-10">{props.player.position}</div>
      </div>
      <div className="row">
        <div className="col-md-2">Status</div>
        <div className="col-md-10">{props.player.status}</div>
      </div>
      <table className="table table-responsive table-borderless small">
        <thead>
          <tr>
            <th>Pvm</th>
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
            <th>Kasvunvara</th>
          </tr>
        </thead>
        <tbody>
          {props.player.data && props.player.data.map(d => <Data key={d.createdAt} data={d} />)}
        </tbody>
      </table>
    </div>
  ) : null

const mapStateToProps = state => ({
  player: R.path(['player', 'player'], state),
})

const mapDispatchToProps = (dispatch, ownProps) => {
  const playerId = R.path(['match', 'params', 'id'], ownProps)
  return {
    getPlayer: dispatch(fetchPlayer(playerId)),
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(PlayerContainer)
