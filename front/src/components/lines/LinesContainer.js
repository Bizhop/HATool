import React from 'react'
import { connect } from 'react-redux'
import R from 'ramda'

import { fetchLines } from './linesActions'

const RenderLine = props => {
  const line = props.line
  const lines = props.lines
  return (
    <div>
      <h4>{R.toUpper(line)}</h4>
      <div className="row">
        <div className="col-md-2 text-center">LW {R.path([line, 'lw', 'name'], lines)}</div>
        <div className="col-md-2 text-center">C {R.path([line, 'c', 'name'], lines)}</div>
        <div className="col-md-2 text-center">RW {R.path([line, 'rw', 'name'], lines)}</div>
      </div>
      <div className="row">
        <div className="col-md-3 text-center">LD {R.path([line, 'ld', 'name'], lines)}</div>
        <div className="col-md-3 text-center">RD {R.path([line, 'rd', 'name'], lines)}</div>
      </div>
    </div>
  )
}

const RenderList = props => {
  const name = props.name
  const list = R.path([props.type], props.lines)
  return (
    <div>
      <h4>{name}</h4>
      {list.map(p => <RenderPlayer key={p.name} player={p} />)}
    </div>
  )
}

const RenderPlayer = props => (
  <div className="row">
    <div className="col-md-2">{props.player.name}</div>
  </div>
)

const LinesContainer = props =>
  props.lines && !props.fetching ? (
    <div className="container">
      <h1>Parhaat ketjut</h1>
      <RenderLine line="y1" lines={props.lines} />
      <RenderLine line="y2" lines={props.lines} />
      <RenderLine line="y3" lines={props.lines} />
      <RenderLine line="y4" lines={props.lines} />
      <RenderLine line="j1" lines={props.lines} />
      <RenderLine line="j2" lines={props.lines} />
      <RenderLine line="j3" lines={props.lines} />
      <RenderList name="Maalivahdit" lines={props.lines} type="goalies" />
      <RenderList name="Myytävät" lines={props.lines} type="sell" />
      <RenderList name="Ylimääräiset" lines={props.lines} type="extra" />
    </div>
  ) : null

const mapStateToProps = state => ({
  lines: R.path(['lines', 'lines'], state),
  fetching: R.path(['lines', 'fetching'], state),
})

const mapDispatchToProps = dispatch => ({
  fetchLines: dispatch(fetchLines()),
})

export default connect(mapStateToProps, mapDispatchToProps)(LinesContainer)
