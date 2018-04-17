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


class TermForm extends React.PureComponent {

  render() {
    return (
      <FormLayout {...this.props}>
        <FormControl margin="normal" fullWidth>
          <InputLabel forHtml="start">Наскільки швидко ви хочете запустити першу версію?</InputLabel>
          <Field id="start" name="start" component={Select}>
            <MenuItem value="1">Проект треба на вчора</MenuItem>
            <MenuItem value="2">Запасу часу немає</MenuItem>
            <MenuItem value="3">Є трохи часу</MenuItem>
            <MenuItem value="4">Часу вдосталь</MenuItem>
          </Field>
        </FormControl>
        <FormControl margin="normal" fullWidth>
          <InputLabel forHtml="change">Інтенсивність внесення змін?</InputLabel>
          <Field id="change" name="change" component={Select}>
            <MenuItem value="1">Шукаємо бізнес модель, весь час зміни</MenuItem>
            <MenuItem value="2">Звичайний темп</MenuItem>
            <MenuItem value="3">Поступове обдуманне внесення змін</MenuItem>
            <MenuItem value="4">Багаторічна фундаментальна підтримка</MenuItem>
          </Field>
        </FormControl>
      </FormLayout>
    );
  }
}

export default form(TermForm);
