package br.org.fundatec.atividade03corrigida.service;

import br.org.fundatec.atividade03.model.Address;

public interface CepService {
    Address findAddressByCep(String cep);
}
