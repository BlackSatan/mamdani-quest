import React from 'react';
import { Field } from 'redux-form/immutable';
import { MenuItem } from 'material-ui/Menu';
import { FormControl } from 'material-ui/Form';
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


class RequirementsForm extends React.PureComponent {

  render() {
    return (
      <FormLayout {...this.props}>
        <FormControl margin="normal" fullWidth>
          <InputLabel forHtml="plan">Чи має ваш проект ТЗ?</InputLabel>
          <Field id="plan" name="plan" component={Select}>
            <MenuItem value="1">Ні</MenuItem>
            <MenuItem value="2">Сформовані основні задачі, але повноцінного тз немає</MenuItem>
            <MenuItem value="3">Так, але очікується внесення незначних змін</MenuItem>
            <MenuItem value="4">Так, всі вимоги повністю прописані</MenuItem>
          </Field>
        </FormControl>
        <FormControl margin="normal" fullWidth>
          <InputLabel forHtml="manage">Підхід до управління проектом?</InputLabel>
          <Field id="manage" name="manage" component={Select}>
            <MenuItem value="1">Ніякий</MenuItem>
            <MenuItem value="2">Waterfall</MenuItem>
            <MenuItem value="3">Kanban</MenuItem>
            <MenuItem value="4">Scram/agile</MenuItem>
          </Field>
        </FormControl>
      </FormLayout>
    );
  }
}

export default form(RequirementsForm);
