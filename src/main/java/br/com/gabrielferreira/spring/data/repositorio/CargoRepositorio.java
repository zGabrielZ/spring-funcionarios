package br.com.gabrielferreira.spring.data.repositorio;

import br.com.gabrielferreira.spring.data.entidade.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepositorio extends CrudRepository<Cargo,Long> {
}
