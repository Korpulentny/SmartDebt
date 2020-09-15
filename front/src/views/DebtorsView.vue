<template>
  <v-container fluid>
    <v-layout>
      <new-debtor-dialog></new-debtor-dialog>
    </v-layout>
    <v-data-table :headers="headers" :items="debtors">
      <template v-slot:item="row">
        <tr>
          <td>{{ row.item.debtorUsername }}</td>
          <td>
            <v-btn class="mx-2" color="blue darken-2" @click="onButtonClick(row.item)">
              Zarządzaj długami
            </v-btn>
          </td>
        </tr>
      </template>
    </v-data-table>
  </v-container>
</template>
<script>
import DebtsService from "../services/debts.service";
import NewDebtorDialog from "@/components/NewDebtorDialog";

export default {
  name: "DebtorsView",
  components: {
    NewDebtorDialog,
  },
  data() {
    return {
      debtors: [],
      headers: [
        { text: 'Dłużnik', value: 'Dłużnik' },
        { text: 'Dodaj dług', value: 'Dodaj dług' },
      ],
    };
  },

  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
    currentUser() {
      return this.$store.state.auth.user;
    },
  },

  created() {
    // fetch the data when the view is created and the data is
    // already being observed
    this.fetchData();

  },
  watch: {
    // call again the method if the route changes
    "$route": "fetchData",
  },
  methods: {
    fetchData() {
      if (!this.loggedIn) {
        this.$router.push("/login");
      } else {
        console.log("lista");
        console.log(this.currentUser);
        DebtsService.getDebtorList(this.currentUser).then(
            successResponse => {
              this.debtors = successResponse.data;
              console.log(this.debtors);
            },
            errorResponse => {
              console.log(errorResponse);
            },
        );
      }

    },
    onButtonClick(item) {
      this.$router.push("/debtor/"+item.debtorUsername);
    },

  },
};
</script>

<style scoped>

</style>