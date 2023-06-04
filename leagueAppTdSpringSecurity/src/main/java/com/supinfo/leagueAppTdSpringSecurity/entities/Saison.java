package com.supinfo.leagueAppTdSpringSecurity.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name="saison")
public class Saison implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@jakarta.persistence.GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = true)
	@Size(min=5,max= 60)
	private String libelle;
	
	@Column(nullable = true)
	@NotEmpty
	@Size(min=5,max= 20)
	private String identifiantSaison;
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getIdentifiantSaison() {
		return identifiantSaison;
	}

	public void setIdentifiantSaison(String identifiantSaison) {
		this.identifiantSaison = identifiantSaison;
	}

	public Saison() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Saison( @Size(min = 5, max = 60) String libelle,
			@NotEmpty @Size(min = 5, max = 20) String identifiantSaison) {
		super();
		this.libelle = libelle;
		this.identifiantSaison = identifiantSaison;
	}
	
	

}
