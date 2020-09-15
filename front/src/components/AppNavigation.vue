<template>
    <v-app-bar color="blue-grey darken-3" dark app>
      <v-btn to="/debtors">Debtors</v-btn>
      <v-spacer></v-spacer>
      <v-btn to="/login">Login</v-btn>
      <v-btn @click="handleLogout">Logout</v-btn>
      <v-btn to="/register">Register</v-btn>
    </v-app-bar>
</template>

<script>
export default {
  name: "AppNavigation",
  methods: {
    handleLogout() {
        this.$store.dispatch("auth/logout", this.user).then(
            () => {
              this.$router.push("/login");
            },
            error => {
              console.log(error);
            },
        );
    },
  },
};
</script>

<style scoped>

</style>