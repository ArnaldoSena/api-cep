package br.com.cep.handler;

import br.com.cep.model.DetalheErro;
import br.com.cep.service.exceptions.CepInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CepExceptionHandler {

    @ExceptionHandler(CepInvalidoException.class)
    public ResponseEntity<DetalheErro> handleLivroNaoEncontradoException(CepInvalidoException e, HttpServletRequest request) {
        DetalheErro erro = new DetalheErro();
        erro.setStatus(400l);
        erro.setMensagem(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
