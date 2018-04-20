import React from 'react';
import Typography from 'material-ui/Typography';
import Paper from 'material-ui/Paper';


import data from './data.json';
import './index.css';


export default class Results extends React.PureComponent {

  getResult = () => {
    const { match: { params: { result } } } = this.props;
    return data.find((item) => item.range[0] <= result && item.range[1] >= result);
  };

  render() {
    const result = this.getResult();
    return (
      <div className="result">
        <div className="result_head">Ваш результат</div>
        <Typography className="result__title" variant="display2" gutterBottom>{result.name}</Typography>
        <hr className="result_line" />
        <Paper className="result_desc">
          {result.desc}
        </Paper>
      </div>
    );
  }
}
