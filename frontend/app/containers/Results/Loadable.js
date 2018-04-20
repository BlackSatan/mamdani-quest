/**
 * Asynchronously loads the component for FormWizzard
 */
import Loadable from 'react-loadable';

export default Loadable({
  loader: () => import('./index'),
  loading: () => null,
});
