import React from 'react';
import Stepper, { Step, StepLabel } from 'material-ui/Stepper';
import steps from './steps';
import './index.css';

export default class HomePage extends React.PureComponent { // eslint-disable-line react/prefer-stateless-function
  constructor(props) {
    super(props);
    this.state = {
      step: 0,
    };
    const socket = new WebSocket('ws://localhost:5005');
    socket.onopen = () => {
      socket.send(JSON.stringify({
        start: '1',
        prop: true,
        level: '1',
        manage: '1',
        load: '10',
        plan: '2',
        salary: '500',
        zone: '1',
        change: '4',
        workers: '1',
      }));
    };

    console.log({
      values: {
        start: '1',
        prop: true,
        level: '1',
        manage: '1',
        load: '10',
        plan: '2',
        salary: '500',
        zone: '1',
        change: '4',
        workers: '1',
      },
    });
  }

  onSubmit() {
    this.setState({ step: this.state.step + 1 });
  }

  render() {
    const { step } = this.state;
    const ActiveStepForm = steps[step].component;
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
        <ActiveStepForm onSubmit={() => this.onSubmit()} />
      </div>
    );
  }
}
