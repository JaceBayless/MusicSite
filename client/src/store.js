import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import getUrl from "@/utils"
import Cookies from "js-cookie";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    token: Cookies.get('user-token') || null
  },
  mutations: {

  },
  actions: {
    login(store, user) {
      return new Promise((resolve, reject) => {
        axios({url: getUrl('login'), data: user, method: 'POST'})
          .then(response => {
            const token = response.headers.authorization.substring(7);
            Cookies.set('user-token', token, { expires: 10 });
            store.state.token = token;
            axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
            resolve();
          }).catch(err => {
            store.state.token = null;
            localStorage.removeItem('user-token');
            reject(err);
          });
      });
    },
    logout(store) {
      return new Promise(resolve => {
        store.state.token = null;
        Cookies.remove('user-token');
        delete axios.defaults.headers.common['Authorization'];
        resolve();
      });
    }
  },
  getters: {
    isAuthenticated(state) {
      return !!state.token;
    }
  }
});
