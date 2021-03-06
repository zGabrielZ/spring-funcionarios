package br.com.gabrielferreira.spring.data.service;

import br.com.gabrielferreira.spring.data.entidade.Funcionario;
import br.com.gabrielferreira.spring.data.entidade.dto.FuncionarioDTO;
import br.com.gabrielferreira.spring.data.entidade.projecao.FuncionarioProjecao;
import br.com.gabrielferreira.spring.data.especificacao.FuncionarioEspecificacao;
import br.com.gabrielferreira.spring.data.repositorio.FuncionarioRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioService {

    private final FuncionarioRepositorio funcionarioRepositorio;

    public RelatorioService(FuncionarioRepositorio funcionarioRepositorio){
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    public List<Funcionario> buscarFuncionarioPorNome(String nome){
        return funcionarioRepositorio.findByNomeLike("%" + nome + "%");
    }

    public List<Funcionario> buscarFuncionarioPorMaiorOuIgualSalario(BigDecimal salario){
        return funcionarioRepositorio.findBySalarioGreaterThanEqual(salario);
    }

    public List<Funcionario> buscarFuncionarioPorMenorOuIgualSalario(BigDecimal salario){
        return funcionarioRepositorio.findBySalarioLessThanEqual(salario);
    }

    public List<Funcionario> buscarFuncionarioPorNomeDataContratacaoSalarioMaiorIgual(String nome, LocalDate dataContratacao, BigDecimal salario){
        return funcionarioRepositorio.buscarNomeDataContratacaoSalarioMaiorIgual(nome,dataContratacao,salario);
    }

    public List<Funcionario> buscarFuncionarioPorDataContratacao(LocalDate dataContratacao){
        return funcionarioRepositorio.buscarDataContratacaoMaiorIgual(dataContratacao);
    }

    public Page<Funcionario> paginacao(Pageable pageable){
        return funcionarioRepositorio.findAll(pageable);
    }

    public List<FuncionarioProjecao> buscarFuncionariosProjecao(){
        return funcionarioRepositorio.buscarFuncionariosProjecao();
    }

    public List<FuncionarioDTO> buscarFuncionariosDto(){
        return funcionarioRepositorio.buscarFuncionariosDto();
    }

    public List<Funcionario> buscarFuncionariosDinamico(String nome,String cpf, BigDecimal salario, LocalDate data, String cargo, String unidade){
        return funcionarioRepositorio.findAll(Specification.where(
                FuncionarioEspecificacao.buscarNome(nome)
                        .and(FuncionarioEspecificacao.buscarCpf(cpf))
                        .and(FuncionarioEspecificacao.buscarSalario(salario))
                        .and(FuncionarioEspecificacao.buscarDataContratacao(data))
                        .and(FuncionarioEspecificacao.buscarCargo(cargo))
                        .and(FuncionarioEspecificacao.buscarUnidade(unidade))
        ));
    }

}
