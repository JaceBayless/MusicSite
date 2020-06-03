<template>
  <b-row class="py-4">
    <b-col cols="10" offset="1" md="6" offset-md="3">
        <h1 class="text-center">
            Contact Us
        </h1>
      <b-form @submit.prevent="contact">
        <b-form-group
          label="Email address:"
          label-for="email"
          description="We'll never share your email with anyone else."
        >
          <b-form-input
            id="email"
            v-model="email"
            type="email"
            required
            placeholder="Enter email"
          ></b-form-input>
        </b-form-group>

        <b-form-group label="Your Name:" label-for="name">
          <b-form-input id="name" v-model="name" required placeholder="Enter name"></b-form-input>
        </b-form-group>
        <b-form-group label="Message:" label-for="message">
            <b-form-textarea v-model="message" id="message" name="message" placeholder="What's on your mind?" rows="3" max-rows="6">
            </b-form-textarea>
        </b-form-group>
        <b-button type="submit" variant="primary">Submit</b-button>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>

export default {
    data(){
        return{
            name: null,
            email: null,
            message: null
        };
    },
    methods:{
        contact(){
        }
    }
}
</script>