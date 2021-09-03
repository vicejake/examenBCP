package com.bcp.pe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.pe.dto.TipoCambioDTO;
import com.bcp.pe.service.TipoCambioService;

import reactor.core.publisher.Flux;


@Controller
@RestController
@RequestMapping("/tipocambio")
public class TipoCambioController {
	
	@Autowired
	private TipoCambioService serv; 
	
	
	@GetMapping(value ="/find" , produces = MediaType.APPLICATION_JSON_VALUE)
	public TipoCambioDTO findByMonedaOrigenAndMonedaDestino(@PathParam("monedaOrigen") String monedaOrigen, @PathParam("monedaDestino") String monedaDestino, @PathParam("monto") double monto){

		return this.serv.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino, monto);

	}
	
	
	//Ejemplo de programación reactiva usando flux para el proceso asincrono
	@GetMapping(value ="/listar" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<TipoCambioDTO> cambios(){
		List<TipoCambioDTO> cam1 = new ArrayList<>();
		TipoCambioDTO dto = new TipoCambioDTO();
		dto.setMonedaDestino("USD");
		dto.setMonedaOrigen("PEN");
		dto.setMonto(50);
		dto.setTipoCambio(3.14);
		dto.setMontoCambio(dto.getMonto()*dto.getTipoCambio());
		cam1.add(dto);
		
		Flux<TipoCambioDTO> cambioFlux = Flux.fromIterable(cam1);
		return cambioFlux;

	}
	
	
	@PostMapping(value = "/save" ,  consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> saveTC(@RequestBody TipoCambioDTO tc){

		
		this.serv.save(tc);
		return ResponseEntity.ok(Boolean.TRUE);

	}

}
