import Requirements from './RequirementsForm';
import Team from './TeamForm';
import Project from './ProjectForm';
import Budget from './BudgetForm';
import Term from './TermForm';

export default [
  {
    name: 'Вимоги',
    component: Requirements,
  },
  {
    name: 'Команда',
    component: Team,
  },
  {
    name: 'Проект',
    component: Project,
  },
  {
    name: 'Бюджет',
    component: Budget,
  },
  {
    name: 'Терміни',
    component: Term,
  },
];
