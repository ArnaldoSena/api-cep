package br.com.cep.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TCep")
public class Cep {

	@Id
	private String cep;

	private String logradouro;

	private String complemento;

	private String bairro;

	@ManyToOne
	private Cidade cidade;

}
