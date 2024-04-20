package br.org.fundatec.atividade03corrigida.service;

import br.org.fundatec.atividade03corrigida.model.Address;
import org.springframework.stereotype.Service;

@Service
public interface CepService {
    Address findAddressByCep(String cep);
}
