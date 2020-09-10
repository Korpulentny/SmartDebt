import axios from "axios";
import AuthorizationService from "./authentication.service";

const DEBTS_SERVICE_URL = "http://localhost:2371/";

class DebtsService {
	getDebtorHistory(user, debtor) {
		return axios
			.get(DEBTS_SERVICE_URL + "history?requesterUsername=" +
				user.username + "&debtorUsername=" + debtor, {
				headers: AuthorizationService.jwtHeader(),
			})
			.then(successResponse => {
				return successResponse;
			})
			.catch(errorResponse => {
				return {};
			});
	}

	getDebtorList(user) {
		return axios
			.get(DEBTS_SERVICE_URL + "debtor-list?requesterId=" + user.username, {
				headers: AuthorizationService.jwtHeader(),
			})
			.then(successResponse => {
				return successResponse;
			})
			.catch(errorResponse => {
				return {};
			});
	}

	addDebtor(user, debtor) {
		return axios
			.post(DEBTS_SERVICE_URL + "debtor?requesterUsername=" +
				user.username + "&debtorUsername=" + debtor, {
				headers: AuthorizationService.jwtHeader(),
			})
			.then(successResponse => {
				return successResponse;
			})
			.catch(errorResponse => {
				return {};
			});
	}

	addDebt(user, debtor) {
		return axios
			.post(DEBTS_SERVICE_URL + "debt?requesterUsername=" +
				user.username + "&debtorUsername=" + debtor, {
				headers: AuthorizationService.jwtHeader(),
			})
			.then(successResponse => {
				return successResponse;
			})
			.catch(errorResponse => {
				return {};
			});
	}


}