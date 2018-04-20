/**
 *
 * App.js
 *
 * This component is the skeleton around the actual pages, and should only
 * contain code that should be seen on all pages. (e.g. navigation bar)
 *
 * NOTE: while this component should technically be a stateless functional
 * component (SFC), hot reloading does not currently support SFCs. If hot
 * reloading is not a necessity for you then you can refactor it and remove
 * the linting exception.
 */

import React from 'react';
import { Switch, Route } from 'react-router-dom';
import AppBar from 'material-ui/AppBar';
import Toolbar from 'material-ui/Toolbar';
import Typography from 'material-ui/Typography';


import HomePage from 'containers/FormWizzard/Loadable';
import NotFoundPage from 'containers/NotFoundPage/Loadable';
import Results from 'containers/Results/Loadable';

export default function App() {
  return (
    <div>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="title" color="inherit">
            Quest App
          </Typography>
        </Toolbar>
      </AppBar>
      <Switch>
        <Route exact path="/" component={HomePage} />
        <Route path="/results/:result" component={Results} />
        <Route component={NotFoundPage} />
      </Switch>
    </div>
  );
}
