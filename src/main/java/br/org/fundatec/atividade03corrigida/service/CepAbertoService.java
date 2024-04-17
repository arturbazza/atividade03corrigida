package br.org.fundatec.atividade03corrigida.service;

import br.org.fundatec.atividade03corrigida.repository.CepAbertoResponseDTO;
import br.org.fundatec.atividade03corrigida.model.Address;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepAbertoService implements CepService {
    @Override
    public Address findAddressByCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String cepAbertoUrl = "https://www.cepaberto.com/api/v3/cep?cep=" + cep;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token token=21e77485e82bf19d0fba79125e8a75ff");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<CepAbertoResponseDTO> response = restTemplate.exchange(cepAbertoUrl, HttpMethod.GET, entity, CepAbertoResponseDTO.class);
        CepAbertoResponseDTO cepAbertoResponseDTO = response.getBody();
        if (cepAbertoResponseDTO != null) {
            Address address = new Address();
            address.setCep(cepAbertoResponseDTO.getCep());
            address.setStreet(cepAbertoResponseDTO.getLogradouro());
            address.setCity(cepAbertoResponseDTO.getCidade());
            address.setState(cepAbertoResponseDTO.getEstado());
            return address;
        }
        return null;
    }
}
