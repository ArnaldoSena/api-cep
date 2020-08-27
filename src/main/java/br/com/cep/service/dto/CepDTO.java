package br.com.cep.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CepDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private CidadeDTO cidade;
}
