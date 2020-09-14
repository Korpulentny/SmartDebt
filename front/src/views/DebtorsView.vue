<template>
  <v-container fluid>
    <v-layout>
      <new-debtor-dialog></new-debtor-dialog>
    </v-layout>
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
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  created() {
    if (!this.currentUser) {
      this.$router.push("/login");
    }
    DebtsService.getDebtorList(this.currentUser).then(
        successResponse => {
          this.debtors = successResponse;
        },
        errorResponse => {
          console.log(errorResponse);
        },
    );
  },
};
</script>

<style scoped>

</style>