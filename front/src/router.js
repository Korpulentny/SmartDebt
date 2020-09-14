import Vue from 'vue';
import Router from 'vue-router';
import DebtorsView from './views/DebtorsView.vue';
import LoginView from './views/LoginView.vue';
import RegisterView from './views/RegisterView.vue';

Vue.use(Router);

const router = new Router({
	mode: 'history',
	routes: [
		{
			path: '/',
			name: 'debtors',
			component: DebtorsView
		},
		{
			path: '/debtors',
			component: DebtorsView
		},
		{
			path: '/login',
			component: LoginView
		},
		{
			path: '/register',
			component: RegisterView
		},
		{
			path: '/debtor',
			name: 'debtor',
			// lazy-loaded
			component: () => import('./views/DebtorView.vue')
		},
	]
});

export default router;