package com.bcp.pe.dto;


public class TipoCambioDTO {
	
	private Long id;
	private String monedaOrigen;
	private String monedaDestino;
	private double tipoCambio;
	private double monto;
	private double montoCambio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public String getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	public double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public double getMontoCambio() {
		return montoCambio ;
	}
	public void setMontoCambio(double montoCambio) {
		this.montoCambio = montoCambio;
	}
	
	
	

}
