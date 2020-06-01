<template>
  <b-row>
    <b-col cols="12" md="8" offset-md="2" class="my-3" v-if="createPost">
      <b-card no-body>
        <b-tabs pills card justified>
          <b-tab active>
            <template v-slot:title>
              Memories
              <b-icon-music-player></b-icon-music-player>
            </template>
            <b-form @submit.prevent="feed">
              <b-form-group label="Song:" label-for="song">
                <b-form-input
                  type="text"
                  v-model="song"
                  id="song"
                  name="song"
                  placeholder="Enter song"
                  required
                ></b-form-input>
              </b-form-group>
              <b-form-group label="Memory:" label-for="memory">
                <b-form-textarea
                  v-model="memory"
                  id="memory"
                  name="memory"
                  placeholder="Enter a memory to share"
                  rows="3"
                  max-rows="6"
                  required
                ></b-form-textarea>
              </b-form-group>
              <div class="text-center">
                <b-button type="Submit" variant="primary" :disabled="loading">Share</b-button>
              </div>
            </b-form>
          </b-tab>
          <b-tab>
            <template v-slot:title>
              Suggestions
              <b-icon-music-note></b-icon-music-note>
            </template>
            <b-form @submit.prevent="feed">
              <b-form-group label="Song:" label-for="suggested-song">
                <b-form-input
                  type="text"
                  v-model="song"
                  id="suggested-song"
                  name="suggested-song"
                  placeholder="Enter song"
                  required
                ></b-form-input>
              </b-form-group>
              <b-form-group label="Why are you suggesting this song?" label-for="suggestion">
                <b-form-textarea
                  v-model="suggestion"
                  id="suggestion"
                  name="suggestion"
                  placeholder="Enter your reason(s)"
                  rows="3"
                  max-rows="6"
                  required
                ></b-form-textarea>
              </b-form-group>
              <div class="text-center">
                <b-button type="Submit" variant="primary" :disabled="loading">Suggest</b-button>
              </div>
            </b-form>
          </b-tab>
          <b-tab>
            <template v-slot:title>
              Review
              <b-icon-pencil-square></b-icon-pencil-square>
            </template>
            <b-form @submit.prevent="feed">
              <b-form-group label="Song:" label-for="rated-song">
                <b-form-input
                  type="text"
                  v-model="song"
                  id="rated-song"
                  name="rated-song"
                  placeholder="Enter song"
                  required
                ></b-form-input>
              </b-form-group>
              <b-form-group label="Enter your rating:" label-for="rating">
                <b-form-rating
                  v-model="rating"
                  variant="primary"
                  class="mb-2"
                  icon-clear="slash-circle"
                  show-clear
                  required
                ></b-form-rating>
              </b-form-group>
              <b-form-group label="Any additional feedback?" label-for="review">
                <b-form-textarea
                  v-model="review"
                  id="review"
                  name="review"
                  placeholder="Enter your review"
                  rows="3"
                  max-rows="6"
                ></b-form-textarea>
              </b-form-group>
              <div class="text-center">
                <b-button type="Submit" variant="primary" :disabled="loading">Review</b-button>
              </div>
            </b-form>
          </b-tab>
        </b-tabs>
      </b-card>
    </b-col>
    <b-col v-else>
      <b-button @click="createPost = true" variant="primary">Create Post</b-button>
    </b-col>
  </b-row>
</template>

<script>
export default {
  data() {
    return {
      song: null,
      memory: null,
      loading: false,
      suggestion: null,
      rating: null,
      review: null,
      createPost: false
    };
  }
};
</script>