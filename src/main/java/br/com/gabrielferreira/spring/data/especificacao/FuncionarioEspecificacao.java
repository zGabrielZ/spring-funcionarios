package br.com.gabrielferreira.spring.data.especificacao;

import br.com.gabrielferreira.spring.data.entidade.Cargo;
import br.com.gabrielferreira.spring.data.entidade.Funcionario;
import br.com.gabrielferreira.spring.data.entidade.Unidade;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioEspecificacao {

    public static Specification<Funcionario> buscarNome(String nome){
        return (root, query, criteriaBuilder) -> {
            if(nome != null && !nome.trim().isEmpty()){
                return criteriaBuilder.like(root.get("nome"),"%" + nome + "%");
            }
            return null;
        };
    }

    public static Specification<Funcionario> buscarCpf(String cpf){
        return (root, query, criteriaBuilder) -> {
            if(cpf != null && !cpf.trim().isEmpty()){
                return criteriaBuilder.equal(root.get("cpf"),cpf);
            }
            return null;
        };
    }

    public static Specification<Funcionario> buscarSalario(BigDecimal salario){
        return (root, query, criteriaBuilder) -> {
            if(salario != null){
                return criteriaBuilder.greaterThanOrEqualTo(root.get("salario"),salario);
            }
            return null;
        };
    }

    public static Specification<Funcionario> buscarDataContratacao(LocalDate dataContratacao){
        return (root, query, criteriaBuilder) -> {
            if(dataContratacao != null){
                return criteriaBuilder.greaterThanOrEqualTo(root.get("dataContratacao"),dataContratacao);
            }
            return null;
        };
    }

    public static Specification<Funcionario> buscarCargo(String cargo){

        return (root, query, criteriaBuilder) -> {
            if(cargo != null && !cargo.trim().isEmpty()){
                Join<Funcionario, Cargo> cargoJoin = root.join("cargo");
                cargoJoin.alias("c");
                return criteriaBuilder.like(cargoJoin.get("descricao"),"%" + cargo + "%");
            }
            return null;
        };
    }

    public static Specification<Funcionario> buscarUnidade(String unidade){

        return (root, query, criteriaBuilder) -> {
            if(unidade != null && !unidade.trim().isEmpty()){
                Join<Funcionario, Unidade> unidadeJoin = root.join("unidade");
                unidadeJoin.alias("u");
                return criteriaBuilder.like(unidadeJoin.get("descricao"),"%" + unidade + "%");
            }
            return null;
        };
    }
}
