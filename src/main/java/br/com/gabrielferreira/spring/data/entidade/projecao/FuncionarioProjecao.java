package br.com.gabrielferreira.spring.data.entidade.projecao;

import java.math.BigDecimal;

public interface FuncionarioProjecao {
    Long getId();

    String getNome();

    BigDecimal getSalario();
}
