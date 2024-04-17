package br.org.fundatec.atividade03corrigida.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CepAbertoResponseDTO {
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
}
