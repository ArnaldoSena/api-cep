package br.com.cep.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TCidade")
public class Cidade {

  @Id
  private String ibge;
  
  private String uf;
  
  private String localidade;

  @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
  private List<Cep> ceps; 
  
}
