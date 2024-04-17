package br.org.fundatec.atividade03corrigida.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrasilApiResponseDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
}
