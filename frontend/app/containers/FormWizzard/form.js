import { compose } from 'redux';
import { reduxForm } from 'redux-form/immutable';

export default compose(
  reduxForm({
    form: 'app',
    destroyOnUnmount: false,
    forceUnregisterOnUnmount: true,
  })
);
