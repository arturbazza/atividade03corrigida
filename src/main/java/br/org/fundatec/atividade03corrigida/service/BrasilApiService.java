package br.org.fundatec.atividade03corrigida.service;

import br.org.fundatec.atividade03corrigida.repository.*;
import br.org.fundatec.atividade03corrigida.model.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BrasilApiService implements CepService {
    @Override
    public Address findAddressByCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String brasilApiUrl = "https://brasilapi.com.br/api/cep/v1/" + cep;
        BrasilApiResponseDTO brasilApiResponseDTO = restTemplate.getForObject(brasilApiUrl, BrasilApiResponseDTO.class);
        if (brasilApiResponseDTO != null) {
            Address address = new Address();
            address.setCep(brasilApiResponseDTO.getCep());
            address.setStreet(brasilApiResponseDTO.getLogradouro());
            address.setCity(brasilApiResponseDTO.getLocalidade());
            address.setState(brasilApiResponseDTO.getUf());
            return address;
        }
        return null;
    }
}
