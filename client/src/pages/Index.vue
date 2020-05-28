<template>
    <div class="text-center">
        <h1>{{ msg }}</h1>
        <b-button variant="secondary" @click="logout">Logout</b-button>
    </div>
</template>
<script>
export default {
    data(){
        return {
            msg: 'Welcome to vue!'
        };
    },
    methods: {
        logout() {
            this.$store.dispatch('logout')
                .then(() => {
                    this.$router.push({
                        path: '/login',
                        query: { logout: true }
                    });
                });
        }
    }
}
</script>