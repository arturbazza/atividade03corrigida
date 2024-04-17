package br.org.fundatec.atividade03corrigida.repository;

import br.org.fundatec.atividade03corrigida.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByCep(String cep);
}
