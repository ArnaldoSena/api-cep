package br.com.cep.service;

import br.com.cep.model.Cep;
import br.com.cep.repository.CepRepostory;
import br.com.cep.service.dto.CepDTO;
import br.com.cep.service.dto.CepFeignDTO;
import br.com.cep.service.exceptions.CepInvalidoException;
import br.com.cep.service.feign.CepClient;
import br.com.cep.service.mapper.CepMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CepService {
    private final CepRepostory cepRepostory;
    private final CepClient cepClient;
    private final CepMapper mapper;

    @Transactional
    public CepDTO findOne(String cep) {
        CepFeignDTO cepFeignDTO;
        CepDTO cepDTO;
        validarCep(cep);
        cep = formatCep(cep);
        Optional<Cep> optionalCep = cepRepostory.findById(cep);

        if (!optionalCep.isPresent()) {
            cepFeignDTO = cepClient.findCepByCep(cep);
            cepDTO = save(cepFeignDTO);
        } else {
            cepDTO = mapper.toDto(optionalCep.get());
        }

        cepDTO.setCep(formatCep(cepDTO.getCep()));

        return cepDTO;
    }

    @Transactional(readOnly = true)
    public List<CepDTO> findByIbgeUf(String ibge, String uf) {
        List<Cep> ceps;
        if (uf == null) {
            ceps = cepRepostory.findAllByCidade_Ibge(ibge);
        } else {
            ceps = cepRepostory.findAllByCidade_IbgeAndCidade_Uf(ibge, uf);
        }
        return ceps.stream().map(item -> {
            item.setCep(formatCep(item.getCep()));
            return mapper.toDto(item);
        }).collect(Collectors.toList());
    }

    private CepDTO save(CepFeignDTO dto) {
        Cep entity = mapper.toEntity(dto);
        entity.setCep(limparCep(entity.getCep()));
        entity = cepRepostory.save(entity);
        return mapper.toDto(entity);
    }

    private void validarCep(String cep) {
        if (cep.length() != 8) {
            throw new CepInvalidoException("Tamanho do CEP inválido!");
        }

        if (!cep.matches("[0-9]*")) {
            throw new CepInvalidoException("O CEP precisa conter apenas numeros!");
        }
    }

    private String limparCep(String cep) {
        return cep.replace("-", "");
    }

    private static String formatCep(String value) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter("#####-###");
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value);
        } catch (ParseException ex) {
            return value;
        }
    }
}
