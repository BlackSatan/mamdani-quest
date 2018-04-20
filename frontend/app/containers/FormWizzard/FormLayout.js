import React from 'react';
import Button from 'material-ui/Button';


export default class FormLayout extends React.PureComponent {

  render() {
    const { handleSubmit, onSubmit, children } = this.props;
    return (
      <form onSubmit={handleSubmit(onSubmit)} className="form">
        <div>
          {children}
        </div>
        <div>
          <Button className="form_button" variant="raised" color="primary" type="submit">
            Далі
          </Button>
        </div>
      </form>
    );
  }
}
