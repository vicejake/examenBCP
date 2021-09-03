package com.bcp.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.pe.model.AutenticarRQ;
import com.bcp.pe.model.AutenticarRS;
import com.bcp.pe.security.JWTUtil;
import com.bcp.pe.security.MyUserDetailsService;

@Controller
@RestController
@RequestMapping("/autenticar")
public class AutenticarController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAutenticar(@RequestBody AutenticarRQ autenticarRQ) throws Exception{
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(autenticarRQ.getUsuario(), autenticarRQ.getContraseña()));
			
			
			
		} catch (BadCredentialsException e) {
			throw new Exception("Usuario y contraseña incorrecta",e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(autenticarRQ.getUsuario());
		final String jwt  = jwtUtil.generateToken(userDetails);
		
		return  ResponseEntity.ok(new AutenticarRS(jwt));
		
	}
}
