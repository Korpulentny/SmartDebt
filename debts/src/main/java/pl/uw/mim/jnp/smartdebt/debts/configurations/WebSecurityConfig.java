//package pl.uw.mim.jnp.smartdebt.debts.configurations;
//
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.web.cors.CorsConfiguration;
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
//		//other config
//	}
//}