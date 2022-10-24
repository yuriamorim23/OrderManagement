package com.javaproject.ordermanagement.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
	
	private final JWTUtil utils;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwt) {
		super(authenticationManager);
		this.utils = jwt;
	}

	public JWTUtil getUtils() {
		return utils;
	}

	//private AuthenticationManager authenticationManager;

	//private JWTUtil jwtUtil;
	
	/*public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}*/
	
	/*public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, password);
		return authenticationManager.authenticate(auth);
		
	}*/
	
	/*@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return authenticationManager;	
	}*/

	/*@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		String username = ((UserSS) auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		res.addHeader("Authorization", "Bearer " + token);
		res.addHeader("access-control-expose-headers", "Authorization");
	}*/
	
	/*@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {

		try {
			UserCredentials cred = new ObjectMapper().readValue(req.getInputStream(), UserCredentials.class);

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(cred.getUsername(),
					cred.getPassword(), new ArrayList<>());

			Authentication auth = authenticationManager.authenticate(authToken);
			return auth;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}*/


	/*private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {

		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				org.springframework.security.core.AuthenticationException exception)
				throws IOException, ServletException {
			
		}
	}*/

		/*private String json() {
			long date = new Date().getTime();
			return "{\"timestamp\": " + date + ", " + "\"status\": 401, " + "\"error\": \"Não autorizado\", "
					+ "\"message\": \"Email ou senha inválidos\", " + "\"path\": \"/login\"}";
		}*/


}
