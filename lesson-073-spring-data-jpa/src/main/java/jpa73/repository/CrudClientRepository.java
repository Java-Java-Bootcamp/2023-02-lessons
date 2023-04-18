package jpa73.repository;

import jpa73.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface CrudClientRepository extends CrudRepository<Client, Long> {
}
