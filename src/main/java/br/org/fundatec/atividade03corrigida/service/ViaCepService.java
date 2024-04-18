package br.org.fundatec.atividade03corrigida.service;

import br.org.fundatec.atividade03corrigida.model.Address;
import br.org.fundatec.atividade03corrigida.repository.ViaCepResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService implements CepService {
    @Override
    public Address findAddressByCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String viaCepUrl = "https://viacep.com.br/ws/" + cep + "/json/";
        ViaCepResponseDTO viaCepResponseDTO = restTemplate.getForObject(viaCepUrl, ViaCepResponseDTO.class);
        if (viaCepResponseDTO != null) {
            Address address = new Address();
            address.setCep(viaCepResponseDTO.getCep());
            address.setStreet(viaCepResponseDTO.getLogradouro());
            address.setCity(viaCepResponseDTO.getLocalidade());
            address.setState(viaCepResponseDTO.getUf());
            return address;
        }
        return null;
    }
}
