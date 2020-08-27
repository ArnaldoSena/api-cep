package br.com.cep.service.exceptions;

public class CepInvalidoException extends RuntimeException {
    public CepInvalidoException(String mensagem) {
        super(mensagem);
    }

    public CepInvalidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
