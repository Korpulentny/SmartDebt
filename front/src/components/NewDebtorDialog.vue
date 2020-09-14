<template>
  <v-row justify="center">
    <v-dialog v-model="dialog" persistent max-width="600px">
      <template v-slot:activator="{ on, attrs }">
        <v-btn
            color="primary"
            dark
            v-bind="attrs"
            v-on="on"
        >
          Open Dialog
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="headline">User Profile</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12" sm="6" md="4">
                <v-text-field label="Debtor username" required v-model="debtor"></v-text-field>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="dialog = false">Close</v-btn>
          <v-btn color="blue darken-1" text @click="handleSave" :disabled="debtor.length===0">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import DebtsService from "../services/debts.service";

export default {
  name: "NewDebtorDialog",
  data() {
    return {
      username: "",
      debtor: "",
      dialog: false,
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },

  methods: {
    handleSave() {
      if (!this.currentUser) {
        // this.$router.push("/login");
      } else {
        this.username = this.currentUser.username;
      }
      console.log(this.username);
      console.log(this.currentUser.username);
      DebtsService.addDebtor(this.currentUser, this.debtor).then(
          () => {
            this.$router.push("/debtors");
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