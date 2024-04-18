package br.org.fundatec.atividade03corrigida.service;

import br.org.fundatec.atividade03corrigida.model.Address;
import br.org.fundatec.atividade03corrigida.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    private AddressRepository addressRepository;

    public Address findAddressByCep(String cep) {

        Address address = null;

        return addressRepository.save(address);
    }
}
