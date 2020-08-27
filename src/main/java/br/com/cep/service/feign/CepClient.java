package br.com.cep.service.feign;

import br.com.cep.service.dto.CepFeignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://viacep.com.br/ws", name = "ceps")
public interface CepClient {

    @GetMapping("/{cep}/json")
    CepFeignDTO findCepByCep(@PathVariable("cep") String cep);
}
