package br.com.cep.controller;

import br.com.cep.service.CepService;
import br.com.cep.service.dto.CepDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ceps")
public class CepController {

    private final CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<CepDTO> findCepByCep(@PathVariable("cep") String cep) {
        return new ResponseEntity<>(cepService.findOne(cep), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CepDTO>> findCepByIbgeUf(@RequestParam("ibge") String ibge, @RequestParam(name = "uf", required = false) String uf) {
        return new ResponseEntity<>(cepService.findByIbgeUf(ibge, uf), HttpStatus.OK);
    }

}
