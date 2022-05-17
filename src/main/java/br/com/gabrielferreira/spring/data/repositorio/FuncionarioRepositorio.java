package br.com.gabrielferreira.spring.data.repositorio;
import br.com.gabrielferreira.spring.data.entidade.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepositorio extends CrudRepository<Funcionario,Long> {
}
