package br.com.gabrielferreira.spring.data.repositorio;
import br.com.gabrielferreira.spring.data.entidade.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepositorio extends CrudRepository<Funcionario,Long> {

    List<Funcionario> findByNomeLike(String nome); // Procurar por nome que vai retornar uma lista

    List<Funcionario> findBySalarioGreaterThanEqual(BigDecimal salario); // Procurar por salario que vai retornar uma lista de maior ou igual ao salario

    List<Funcionario> findBySalarioLessThanEqual(BigDecimal salario); // Procurar por salario que vai retornar uma lista de menor ou igual ao salario

    @Query("SELECT f FROM Funcionario f where f.nome = :nome and f.dataContratacao = :dataContratacao and f.salario >= :salario")
    List<Funcionario> buscarNomeDataContratacaoSalarioMaiorIgual(@Param("nome") String nome,@Param("dataContratacao") LocalDate dataContratacao,@Param("salario") BigDecimal salario);

    @Query(value = "SELECT f.* FROM funcionarios f where f.data_contratacao >= :dataContratacao",nativeQuery = true)
    List<Funcionario> buscarDataContratacaoMaiorIgual(@Param("dataContratacao") LocalDate dataContratacao);

}
