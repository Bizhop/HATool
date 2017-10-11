import React from 'react'
import { Field, reduxForm } from 'redux-form'

const RenderSelectInput = ({ input, label, type, options, meta: { touched, error } }) => {
  const optionList = options.map(opt => (
    <option key={opt.value} value={opt.value}>
      {opt.name}
    </option>
  ))
  return (
    <div className="form-group">
      <label className="form-control-label" htmlFor={input.name}>
        {label}
      </label>
      <select className="form-control" {...input} type={type}>
        <option value="">Valitse...</option>
        {optionList}
      </select>
      {touched && error && <span className="text-danger">{error}</span>}
    </div>
  )
}

const positionList = [
  { name: 'G', value: 'G' },
  { name: 'D', value: 'D' },
  { name: 'C', value: 'C' },
  { name: 'W', value: 'W' },
]

const statusList = [
  { name: 'MV', value: 'MV' },
  { name: 'Y1P', value: 'Y1P' },
  { name: 'Y2', value: 'Y2' },
  { name: 'Y3', value: 'Y3' },
  { name: 'Y4J', value: 'Y4J' },
  { name: 'J', value: 'J' },
  { name: 'USC', value: 'USC' },
  { name: 'SELL', value: 'SELL' },
  { name: 'NEW', value: 'NEW' },
]

const updatePlayerForm = props => (
  <form onSubmit={props.handleSubmit}>
    <div className="row">
      <div className="col-md-2">
        <Field
          name="position"
          label="Pelipaikka"
          component={RenderSelectInput}
          options={positionList}
        />
      </div>
    </div>
    <div className="row">
      <div className="col-md-2">
        <Field name="status" label="Status" component={RenderSelectInput} options={statusList} />
      </div>
    </div>
    <button type="submit" className="btn btn-primary">
      Päivitä tiedot
    </button>
  </form>
)

export default reduxForm({ form: 'updatePlayerForm' })(updatePlayerForm)
