package com.bcp.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.bcp.pe.model.TipoCambio;


@Service
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {

	TipoCambio findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);

}
