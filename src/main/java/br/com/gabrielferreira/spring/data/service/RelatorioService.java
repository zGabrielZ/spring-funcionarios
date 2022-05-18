package br.com.gabrielferreira.spring.data.service;

import br.com.gabrielferreira.spring.data.entidade.Funcionario;
import br.com.gabrielferreira.spring.data.repositorio.FuncionarioRepositorio;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

}