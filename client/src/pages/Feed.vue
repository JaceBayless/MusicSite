<template>
  <b-row class="py-4">
    <b-col cols="12" md="8" offset-md="2" class="my-3" v-if="createPost">
    <Post>
    </Post>
    </b-col>
    <b-col md="8" offset-md="2" cols="10" offset="1" v-else>
      <b-form @submit.prevent= 'createPost=true'>
        <b-input-group>
          <b-form-input v-model="song" type="text" placeholder="Enter Song" required></b-form-input>
          <template v-slot:append>
            <b-button variant="primary" type="submit">Create Post</b-button>
          </template>
        </b-input-group>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import Post from "../Components/Post.vue"
export default {
  components:{Post},
  data() {
    return {
      createPost: false
    };
  }
};
</script>