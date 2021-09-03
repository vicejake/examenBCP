package com.bcp.pe.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "tipocambio")
public class TipoCambio  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String monedaOrigen;

	private String monedaDestino;
	
	private LocalDate fecha;
	

	private double tipoCambio;
	
	@PrePersist
	@PreUpdate
	public void prePersist() {
		fecha = LocalDate.now();	
	}

	

	

}
