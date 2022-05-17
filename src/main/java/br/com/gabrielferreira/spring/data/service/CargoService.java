package br.com.gabrielferreira.spring.data.service;

import br.com.gabrielferreira.spring.data.entidade.Cargo;
import br.com.gabrielferreira.spring.data.repositorio.CargoRepositorio;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CargoService {

    private final CargoRepositorio cargoRepositorio;

    public CargoService(CargoRepositorio cargoRepositorio){
        this.cargoRepositorio = cargoRepositorio;
    }

    public Cargo inserir(Cargo cargo){
        return cargoRepositorio.save(cargo);
    }

    public void deletarTudo(){
        cargoRepositorio.deleteAll();
    }

    public Iterable<Cargo> mostrarCargos(){
        return cargoRepositorio.findAll();
    }

    public Cargo mostrarCargo(Long id){
        Optional<Cargo> optionalCargo = cargoRepositorio.findById(id);
        return optionalCargo.orElse(null);
    }

    public void deletarPorId(Long id){
        cargoRepositorio.deleteById(id);
    }
}
