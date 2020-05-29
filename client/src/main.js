import Vue from "vue";
import App from "@/App";
import router from "@/router";
import store from "@/store";
import 'bootstrap-vue/dist/bootstrap-vue.css';
import {BootstrapVue, BootstrapVueIcons} from 'bootstrap-vue';
import axios from "axios";
import Cookies from "js-cookie";

Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);

Vue.config.productionTip = false;

const token = Cookies.get('user-token');
if (token) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
}

new Vue({
  router,
  store,
  render: h => h(App),
  created() {
    axios.interceptors.response.use(undefined, (err) => {
      return new Promise((resolve, reject) => {
          if (err.response.status === 403 && err.config && !err.config.__isRetryRequest) {
              this.$store.dispatch('logout');
              this.$router.push({
                  path: '/login',
                  query: { expired: true }
              });
          }
          throw err;
      });
    });
  }
}).$mount("#app");
