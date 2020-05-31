<template>
  <b-row>
    <b-col cols="12" md="6" offset-md="3" class="my-md-4 py-3">
      <b-tabs v-model="tabPage" content-class="mt-3" fill>
        <b-tab title="Login" active>
          <h1 class="pb-3 border-bottom text-center">Login</h1>
          <b-alert :show="loggedOut" variant="success" dismissible>You have been logged out.</b-alert>
          <b-alert
            :show="expired"
            variant="danger"
            dismissible
          >Your session has expired. Please login again.</b-alert>
          <b-alert v-model="error" variant="danger" dismissible>Incorrect username or password.</b-alert>
          <b-alert v-model="registered" variant="success" dismissible>Registration completed.</b-alert>
          <b-form @submit.prevent="login">
            <b-form-group label="Username:" label-for="username">
              <b-form-input v-model="username" id="username" name="username"></b-form-input>
            </b-form-group>
            <b-form-group label="Password:" label-for="password">
              <b-form-input type="password" v-model="password" id="password" name="password"></b-form-input>
            </b-form-group>
            <div class="text-center">
              <b-button type="submit" variant="primary" :disabled="loading">Login</b-button>
            </div>
          </b-form>
        </b-tab>
        <b-tab title="Register">
          <h1 class="pb-3 border-bottom text-center">Register</h1>
          <b-alert v-model="passwordError" variant="danger" dismissible>Mismatched password.</b-alert>
          <b-alert v-model="registerError" variant="danger" dismissible>Username already exists.</b-alert>
          <b-form @submit.prevent="register">
            <b-form-group label="Username:" label-for="register-username">
              <b-form-input v-model="username" id="register-username" name="register-username"></b-form-input>
            </b-form-group>
            <b-form-group label="Password:" label-for="register-password">
              <b-form-input
                type="password"
                v-model="password"
                id="register-password"
                name="register-password"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="Confirm Password:" label-for="confirm-password">
              <b-form-input
                type="password"
                v-model="confirmPassword"
                id="confirm-password"
                name="confirm-password"
              ></b-form-input>
            </b-form-group>
            <div class="text-center">
              <b-button type="submit" variant="primary" :disabled="loading">Register</b-button>
            </div>
          </b-form>
        </b-tab>
      </b-tabs>
    </b-col>
  </b-row>
</template>
<script>
import axios from "axios";
import getUrl from "@/utils";
export default {
  data() {
    return {
      username: null,
      password: null,
      confirmPassword: null,
      loading: false,
      error: false,
      passwordError: false,
      registerError: false,
      registered: false,
      tabPage: 0
    };
  },
  methods: {
    login() {
      this.loading = true;
      this.$store
        .dispatch("login", { username: this.username, password: this.password })
        .then(() => {
          const redirect = this.$route.query.redirect;
          this.$router.push(redirect ?? "/");
        })
        .catch(err => {
          this.error = true;
        })
        .finally(() => {
          this.loading = false;
        });
    },
    register() {
      if (this.password !== this.confirmPassword) {
        this.passwordError = true;
      } else {
        this.passwordError = false;
        this.loading = true;
        axios({
          url: getUrl("register"),
          data: { username: this.username, password: this.password },
          method: "POST"
        })
          .then(response => {
            if (response.data) {
              this.tabPage = 0;
              this.registered = true;
            } else {
              this.registerError = true;
            }
          })
          .catch(err => {
            this.registerError = true;
          })
          .finally(() => {
            this.loading = false;
          });
      }
    }
  },
  computed: {
    loggedOut() {
      return !!this.$route.query.logout;
    },
    expired() {
      return !!this.$route.query.expired;
    }
  }
};
</script>