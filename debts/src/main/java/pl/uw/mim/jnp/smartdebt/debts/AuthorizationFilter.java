package pl.uw.mim.jnp.smartdebt.debts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.web.util.WebUtils;
import pl.uw.mim.jnp.smartdebt.debts.models.constants.Constants;
import pl.uw.mim.jnp.smartdebt.debts.services.UserAuthorizationService;


@Component
public class AuthorizationFilter extends HttpFilter {

	@Autowired
	private UserAuthorizationService authorizationService;

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		String jwt = req.getHeader(Constants.AUTHORIZATION_HEADER_STRING);
		if (jwt == null || !authorizationService.authorizeToken(jwt)) {
			res.sendError(401, Constants.UNAUTHORIZED_REQUEST_MESSAGE);
		}
//		HttpServletResponse response = (HttpServletResponse) res;
//		response.setHeader(X_CLACKS_OVERHEAD, "GNU Terry Pratchett");
		chain.doFilter(req, res);
	}
}
