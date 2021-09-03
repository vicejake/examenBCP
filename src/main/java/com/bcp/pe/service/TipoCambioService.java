package com.bcp.pe.service;


import com.bcp.pe.dto.TipoCambioDTO;



public interface TipoCambioService {
	
	
	void save(TipoCambioDTO t);
	TipoCambioDTO findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino, double monto);


}
