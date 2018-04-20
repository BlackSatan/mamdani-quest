import React from 'react';
import { connect } from 'react-redux';
import { push } from 'react-router-redux';
import Stepper, { Step, StepLabel } from 'material-ui/Stepper';
import steps from './steps';
import './index.css';

class FormWizzard extends React.PureComponent { // eslint-disable-line react/prefer-stateless-function
  constructor(props) {
    super(props);
    this.state = {
      step: 0,
      connection: false,
      socket: null,
    };
    const socket = new WebSocket('ws://localhost:5006');
    socket.onopen = () => {
      this.setState({ connection: true, socket });
    };

    // console.log({
    //   values: {
    //     start: '1',
    //     prop: true,
    //     level: '1',
    //     manage: '1',
    //     load: '10',
    //     plan: '2',
    //     salary: '500',
    //     zone: '1',
    //     change: '4',
    //     workers: '1',
    //   },
    // });
  }

  onSubmit(values) {
    if (this.state.step + 1 >= steps.length) {
      this.state.socket.onmessage = (e) => {
        this.props.redirect(parseInt(e.data, 10));
      };
      this.state.socket.send(JSON.stringify({
        ...values.toJS(),
        prop: values.get('prop') ? '1' : '0',
      }));
    } else {
      this.setState({ step: this.state.step + 1 });
    }
  }

  render() {
    const { step, connection } = this.state;
    const ActiveStepForm = steps[step].component;

    if (!connection) {
      return <div>Loading...</div>;
    }

    return (
      <div>
        <Stepper activeStep={step}>
          {steps.map((stepConfig, index) => (
            <Step key={stepConfig.name} completed={index < step}>
              <StepLabel>{stepConfig.name}</StepLabel>
            </Step>
            )
          )}
        </Stepper>
        <ActiveStepForm onSubmit={(data) => this.onSubmit(data)} />
      </div>
    );
  }
}

export default connect(() => ({}), (dispatch) => ({
  redirect(result) {
    dispatch(push(`/results/${result}`));
  },
}))(FormWizzard);
