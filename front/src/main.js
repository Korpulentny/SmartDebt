import VeeValidate from 'vee-validate';
import '@babel/polyfill';
import Vue from 'vue';
import Vuetify from "vuetify";
import App from './App.vue';
import router from './router';
import store from './store';

Vue.config.productionTip = false;


const app = new Vue({
	router,
	store,
	VeeValidate,
	Vuetify,
	render: h => h(App)
}).$mount('#app');

export default app;