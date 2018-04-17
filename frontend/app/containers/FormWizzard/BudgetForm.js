import React from 'react';
import { Field } from 'redux-form/immutable';
import { MenuItem } from 'material-ui/Menu';
import { FormControl, FormControlLabel } from 'material-ui/Form';
import { InputLabel, InputAdornment } from 'material-ui/Input';
import {
  Checkbox,
  RadioGroup,
  Select,
  TextField,
  Switch,
} from 'redux-form-material-ui';

import FormLayout from './FormLayout';
import form from './form';


class BudgetForm extends React.PureComponent {

  render() {
    return (
      <FormLayout {...this.props}>
        <Field
          name="salary"
          component={TextField}
          label="Середня зарплата розробника"
          fullWidth
          InputProps={{
            endAdornment: <InputAdornment position="start">$</InputAdornment>,
          }}
        />
        <FormControl margin="normal" fullWidth>
          <FormControlLabel control={<Field name="prop" component={Switch} />} label="Чи готові ви платити за пропрієтарне по?" />
        </FormControl>
      </FormLayout>
    );
  }
}

export default form(BudgetForm);
