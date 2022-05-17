package br.com.gabrielferreira.spring.data.service;

import br.com.gabrielferreira.spring.data.entidade.Cargo;
import br.com.gabrielferreira.spring.data.entidade.Unidade;
import br.com.gabrielferreira.spring.data.repositorio.CargoRepositorio;
import br.com.gabrielferreira.spring.data.repositorio.UnidadeRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnidadeService {

    private final UnidadeRepositorio unidadeRepositorio;

    public UnidadeService(UnidadeRepositorio unidadeRepositorio){
        this.unidadeRepositorio = unidadeRepositorio;
    }

    public Unidade inserir(Unidade unidade){
        return unidadeRepositorio.save(unidade);
    }

    public void deletarTudo(){
        unidadeRepositorio.deleteAll();
    }

    public Iterable<Unidade> mostrarUnidades(){
        return unidadeRepositorio.findAll();
    }

    public Unidade mostrarUnidade(Long id){
        Optional<Unidade> optionalUnidade = unidadeRepositorio.findById(id);
        return optionalUnidade.orElse(null);
    }

    public void deletarPorId(Long id){
        unidadeRepositorio.deleteById(id);
    }
}
