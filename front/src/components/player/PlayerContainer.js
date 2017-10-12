import React from 'react'
import R from 'ramda'
import { connect } from 'react-redux'

import { fetchPlayer, updatePlayer } from './playerActions'
import UpdatePlayerForm from './UpdatePlayerForm'

const Data = props => {
  const data = props.data
  return (
    <tr>
      <td>{data.createdAt}</td>
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
      <td>{data.efficiency}</td>
    </tr>
  )
}

const initialValues = player => ({
  id: player.id,
  position: player.position,
  status: player.status,
  loyalty: player.loyalty,
})

const PlayerContainer = props =>
  props.player && !props.fetching ? (
    <div className="container">
      <div className="row">
        <div className="col-md-2">Nimi</div>
        <div className="col-md-10">{props.player.name}</div>
      </div>
      <div className="row">
        <div className="col-md-2">Ikä</div>
        <div className="col-md-10">{props.player.age}</div>
      </div>
      <div className="row">
        <div className="col-md-2">Lahjakkuus / Potentiaali</div>
        <div className="col-md-10">
          {props.player.quality} / {props.player.potential}
        </div>
      </div>
      <UpdatePlayerForm onSubmit={props.updatePlayer} initialValues={initialValues(props.player)} />
      <table className="table table-responsive table-borderless small">
        <thead>
          <tr>
            <th>Pvm</th>
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
            <th>Tehokkuus</th>
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
  fetching: R.path(['player', 'fetching'], state),
})

const mapDispatchToProps = (dispatch, ownProps) => {
  const playerId = R.path(['match', 'params', 'id'], ownProps)
  return {
    getPlayer: dispatch(fetchPlayer(playerId)),
    updatePlayer: params => dispatch(updatePlayer(params)),
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(PlayerContainer)
