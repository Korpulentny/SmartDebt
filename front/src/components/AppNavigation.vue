<template>
  <v-app>
    <v-toolbar app color="blue-grey darken-3" dark>
      <v-btn flat to="/debtors">Debtors</v-btn>
      <v-btn flat to="/debts">Debts</v-btn>
      <v-btn flat to="/login">Login</v-btn>
      <v-btn flat>Logout</v-btn>
      <v-btn flat to="/register">Register</v-btn>
    </v-toolbar>
  </v-app>
</template>

<script>
export default {
  name: "AppNavigation",
};
</script>

<style scoped>

</style>