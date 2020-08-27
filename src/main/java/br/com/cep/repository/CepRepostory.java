package br.com.cep.repository;

import br.com.cep.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CepRepostory extends JpaRepository<Cep, String> {
    List<Cep> findAllByCidade_IbgeAndCidade_Uf(String ibge, String uf);

    List<Cep> findAllByCidade_Ibge(String ibge);
}
