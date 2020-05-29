<template>
  <div>
    <b-row>
      <b-navbar class="col primary-blue" toggleable="md" type="dark">
        <b-navbar-brand href="#" class="display-font mr-5">
          <h2 class="m-0">Music Site</h2>
        </b-navbar-brand>
        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
        <b-collapse id="nav-collapse" is-nav>
          <b-nav-form inline class="rounded-full bg-white px-3">
            <b-icon icon="search" variant="secondary" class="mb-0"></b-icon>
            <b-form-input size="md" class="mr-sm-3 border-0 focus-0 mb-1" placeholder="Search"></b-form-input>
          </b-nav-form>
          <b-navbar-nav class="ml-auto">
            <b-nav-item-dropdown class="active" right>
              <template v-slot:button-content>User</template>
              <b-dropdown-item href="#">Profile</b-dropdown-item>
              <b-dropdown-item href="#">Sign Out</b-dropdown-item>
            </b-nav-item-dropdown>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </b-row>
    <b-row>
      <b-col>
        <router-view />
      </b-col>
    </b-row>
  </div>
</template>

<style>
.container-fluid {
  font-family: "Lato", sans-serif;
}

.primary-blue {
  background-color: #267bd5;
  color: #fff;
}

.display-font {
  font-family: "Lobster", cursive;
}

.header-font {
  font-family: "Raleway", sans-serif;
}

.rounded-full {
  border-radius: 1000px;
}

.focus-0:focus {
  outline: none;
  box-shadow: none;
}
</style>


<!--Search Bar Fix-->
<style scoped>
.form-inline {
  flex-flow: row;
}
</style>