package br.com.gabrielferreira.spring.data.service;

import br.com.gabrielferreira.spring.data.entidade.Funcionario;
import br.com.gabrielferreira.spring.data.repositorio.FuncionarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepositorio funcionarioRepositorio;

    public FuncionarioService(FuncionarioRepositorio funcionarioRepositorio){
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    public Funcionario inserir(Funcionario funcionario){
        return funcionarioRepositorio.save(funcionario);
    }

    public void deletarTudo(){
        funcionarioRepositorio.deleteAll();
    }

    public Iterable<Funcionario> mostrarFuncionarios(){
        return funcionarioRepositorio.findAll();
    }

    public Funcionario mostrarFuncionario(Long id){
        Optional<Funcionario> optionalFuncionario = funcionarioRepositorio.findById(id);
        return optionalFuncionario.orElse(null);
    }

    public void deletarPorId(Long id){
        funcionarioRepositorio.deleteById(id);
    }
}
