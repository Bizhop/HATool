import React from 'react'
import { Field, reduxForm } from 'redux-form'

import { RenderInputField } from '../shared/FormInput'

const importForm = props => (
  <form onSubmit={props.handleSubmit}>
    <div className="row">
      <div className="col-md-12">
        <Field name="cookie" label="Cookie" type="text" component={RenderInputField} />
      </div>
    </div>
    <button type="submit" className="btn btn-primary">
      Lähetä cookie
    </button>
  </form>
)

export default reduxForm({ form: 'importForm' })(importForm)
