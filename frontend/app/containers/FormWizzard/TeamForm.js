import React from 'react';
import { Field } from 'redux-form/immutable';
import { MenuItem } from 'material-ui/Menu';
import { FormControl, FormControlLabel } from 'material-ui/Form';
import { InputLabel } from 'material-ui/Input';
import {
  Checkbox,
  RadioGroup,
  Select,
  TextField,
  Switch,
} from 'redux-form-material-ui';
import FormLayout from './FormLayout';
import form from './form';


class TeamForm extends React.PureComponent {

  render() {
    return (
      <FormLayout {...this.props}>
        <Field name="workers" component={TextField} label="Кількість членів команди?" fullWidth />
        <FormControl margin="normal" fullWidth>
          <InputLabel forHtml="level">Середній професіоналізм команди?</InputLabel>
          <Field id="level" name="level" component={Select}>
            <MenuItem value="1">Початківці</MenuItem>
            <MenuItem value="2">Junior</MenuItem>
            <MenuItem value="3">Middle</MenuItem>
            <MenuItem value="4">Senior</MenuItem>
            <MenuItem value="5">Dream Team</MenuItem>
          </Field>
        </FormControl>
        <FormControl margin="normal" fullWidth>
          <FormControlLabel control={<Field name="lol" component={Switch} />} label="В команді буде DevOps і QA?" />
        </FormControl>
      </FormLayout>
    );
  }
}

export default form(TeamForm);
