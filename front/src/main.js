import { createApp } from 'vue'
import App from './App.vue'

import { router } from './router';
import store from './store';
import axios from "axios"
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import VeeValidate from 'vee-validate';

const app = createApp(App)
	.use(router)
	.use(store)
	.use(VeeValidate)
	.mount("#app");

