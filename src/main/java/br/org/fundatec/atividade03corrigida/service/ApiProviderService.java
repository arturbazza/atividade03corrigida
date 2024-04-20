package br.org.fundatec.atividade03corrigida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApiProviderService {
    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private BrasilApiService brasilApiService;

    @Autowired
    private CepAbertoService cepAbertoService;

    @Value("${app.cep.api}")
    private String apiProvider;

    public CepService getApiProvider() {
        switch (apiProvider) {
            case "VIACEP":
                return viaCepService;
            case "BRASILAPI":
                return brasilApiService;
            case "CEPABERTO":
                return cepAbertoService;
            default:
                throw new IllegalStateException("Provedor de API sem suporte: " + apiProvider);
        }
    }
}
