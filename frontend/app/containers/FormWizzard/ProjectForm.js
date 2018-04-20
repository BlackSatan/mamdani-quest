import React from 'react';
import { Field } from 'redux-form/immutable';
import { MenuItem } from 'material-ui/Menu';
import { FormControl } from 'material-ui/Form';
import { InputLabel } from 'material-ui/Input';
import {
  Select,
} from 'redux-form-material-ui';
import FormLayout from './FormLayout';
import form from './form';


class ProjectForm extends React.PureComponent {

  render() {
    return (
      <FormLayout {...this.props}>
        <FormControl margin="normal" fullWidth>
          <InputLabel forHtml="zone">Прикладна область проекту?</InputLabel>
          <Field id="zone" name="zone" component={Select}>
            <MenuItem value="1">Інформаційний сайт</MenuItem>
            <MenuItem value="2">B2C</MenuItem>
            <MenuItem value="3">B2B</MenuItem>
            <MenuItem value="4">Fintech</MenuItem>
            <MenuItem value="5">Інновації</MenuItem>
          </Field>
        </FormControl>
        <FormControl margin="normal" fullWidth>
          <InputLabel forHtml="load">Очікуванне навантаження в запитах на секунду?</InputLabel>
          <Field id="load" name="load" component={Select}>
            <MenuItem value="10">1-10</MenuItem>
            <MenuItem value="50">10-50</MenuItem>
            <MenuItem value="100">50-100</MenuItem>
            <MenuItem value="1000">100-1000</MenuItem>
            <MenuItem value="5000">1000-5000</MenuItem>
            <MenuItem value="10000">5000-10000</MenuItem>
            <MenuItem value="100000">10 000-100 000</MenuItem>
            <MenuItem value="1000000">100 000-1 000 000</MenuItem>
          </Field>
        </FormControl>
      </FormLayout>
    );
  }
}

export default form(ProjectForm);
