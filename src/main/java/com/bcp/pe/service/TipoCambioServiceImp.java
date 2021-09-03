package com.bcp.pe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.pe.common.MHelpers;
import com.bcp.pe.dto.TipoCambioDTO;
import com.bcp.pe.model.TipoCambio;
import com.bcp.pe.repository.TipoCambioRepository;


@Service
public class TipoCambioServiceImp implements TipoCambioService{

	@Autowired
	private TipoCambioRepository repo;
	
	@Override
	public void save(TipoCambioDTO t) {
		
		TipoCambio tc = MHelpers.modelMapper().map(t, TipoCambio.class);
		this.repo.save(tc);

}

	@Override
	public TipoCambioDTO findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino, double monto) {
		TipoCambio tc = this.repo.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);
		TipoCambioDTO cambioDTO = MHelpers.modelMapper().map(tc, TipoCambioDTO.class);
		double montoCambiado = tc.getTipoCambio() * monto;
		cambioDTO.setMonto(monto);
		cambioDTO.setMontoCambio(montoCambiado);
		
		return cambioDTO;
	}



}