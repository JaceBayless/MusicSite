import Vue from "vue";
import VueRouter from "vue-router";
import store from "@/store";
import Index from "@/pages/Index";
import Login from "@/pages/Login";
import NotFound from "@/pages/NotFound";

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    component: Index,
    //meta: { requiresAuth: true }
  },
  {
    path: '/login',
    component: Login,
    beforeEnter(to, from, next) {
      if (!store.getters.isAuthenticated) {
        next();
        return;
      }
      next('/');
    }
  },
  {
    path: '*',
    component: NotFound
  }
];

const router = new VueRouter({
  mode: "history",
  base: '/',
  routes
});

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth)) {
    if (!store.getters.isAuthenticated) {
      next({
        path: '/login',
        query: { redirect: to.fullPath }
      });
    } else {
      next();
    }
  } else {
    next();
  }
});

export default router;
