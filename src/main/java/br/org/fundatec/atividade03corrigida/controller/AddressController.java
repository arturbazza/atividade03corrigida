package br.org.fundatec.atividade03corrigida.controller;

import br.org.fundatec.atividade03corrigida.model.Address;
import br.org.fundatec.atividade03corrigida.service.ApiProviderService;
import br.org.fundatec.atividade03corrigida.service.CepService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class AddressController {
    @Autowired
    private ApiProviderService apiProviderService;

    @GetMapping("/address/{cep}")
    public Address getAddressByCep(@PathVariable String cep) {
        CepService cepService = apiProviderService.getApiProvider();
        return cepService.findAddressByCep(cep);
    }
}
