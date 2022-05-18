package br.com.gabrielferreira.spring.data.repositorio;
import br.com.gabrielferreira.spring.data.entidade.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FuncionarioRepositorio extends CrudRepository<Funcionario,Long> {

    List<Funcionario> findByNomeLike(String nome); // Procurar por nome que vai retornar uma lista

    List<Funcionario> findBySalarioGreaterThanEqual(BigDecimal salario); // Procurar por salario que vai retornar uma lista de maior ou igual ao salario

    List<Funcionario> findBySalarioLessThanEqual(BigDecimal salario); // Procurar por salario que vai retornar uma lista de menor ou igual ao salario
}
