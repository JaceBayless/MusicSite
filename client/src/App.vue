<template>
  <div class="min-vh-100 d-flex flex-column">
    <b-row class="flex-grow-0">
      <b-navbar class="col primary-blue" toggleable="md" type="dark">
        <b-navbar-brand href="#" class="display-font mr-5">
          <h2 class="m-0">Music Site</h2>
        </b-navbar-brand>
        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
        <b-collapse id="nav-collapse" is-nav>
          <b-nav-form inline class="px-md-3" autocomplete="off">
            <b-form-input size="md" class="rounded-full search" placeholder="Search"></b-form-input>
          </b-nav-form>
          <b-navbar-nav class="ml-auto header-font h5">
            <b-nav-item-dropdown class="active" right>
              <template v-slot:button-content>
                <b-avatar :src="profileImageUrl" size="3rem" class="mx-2"></b-avatar>
                {{ username }}
              </template>
              <b-dropdown-item href="#">Profile</b-dropdown-item>
              <b-dropdown-item href="#">Sign Out</b-dropdown-item>
            </b-nav-item-dropdown>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </b-row>
    <b-row class="bg-e8 flex-grow-1">
      <b-col class="bg-white col-10 offset-1 col-md-8 offset-md-2 my-4 rounded shadow-sm">
        <router-view />
      </b-col>
    </b-row>
    <b-row class="primary-blue text-center flex-grow-0">
      <b-col>
        <b-col class="col-12 my-2" style="font-size:14pt;">
          <router-link to="#" class="text-white">About Us</router-link>
          <router-link to="#" class="text-white mx-5">Contact Us</router-link>
          <b-link href="https://github.com/JaceBayless/MusicSite" class="text-white">Github</b-link>
        </b-col>
        <b-col
          class="col-12 my-1"
          style="font-size:10pt;"
        >&copy;2020 Music Site - All Rights Reserved</b-col>
      </b-col>
    </b-row>
  </div>
</template>
<script>
export default {
  data() {
    return {
      profileImageUrl: "https://trivia.house/img/aboutus/JaceHeadshot.jpeg",
      username: "SlippySnake"
    };
  }
};
</script>
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

.search {
  background: url("data:image/svg+xml,%3Csvg data-v-7ba5bd90='' viewBox='0 0 16 16' width='1em' height='1em' xmlns='http://www.w3.org/2000/svg' fill='none' stroke='%236c757d'%3E%3Cg%3E%3Cpath fill-rule='evenodd' d='M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z'%3E%3C/path%3E%3Cpath fill-rule='evenodd' d='M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z'%3E%3C/path%3E%3C/g%3E%3C/svg%3E")
    #fff no-repeat left 0.75rem center/1rem 1rem;
  padding-left: 2.25rem;
}
</style>

<style scoped>
.bg-e8 {
  background-color: #e8e8e8;
}
</style>