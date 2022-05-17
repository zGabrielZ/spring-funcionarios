package br.com.gabrielferreira.spring.data.repositorio;
import br.com.gabrielferreira.spring.data.entidade.Unidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepositorio extends CrudRepository<Unidade,Long> {
}
