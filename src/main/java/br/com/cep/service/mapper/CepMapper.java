package br.com.cep.service.mapper;

import br.com.cep.model.Cep;
import br.com.cep.service.dto.CepDTO;
import br.com.cep.service.dto.CepFeignDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface CepMapper {

    @Mapping(source = "localidade", target = "cidade.localidade")
    @Mapping(source = "uf", target = "cidade.uf")
    @Mapping(source = "ibge", target = "cidade.ibge")
    Cep toEntity(CepFeignDTO dto);

    CepDTO toDto(Cep entity);
}
