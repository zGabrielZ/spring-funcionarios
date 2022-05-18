package br.com.gabrielferreira.spring.data.entidade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FuncionarioDTO implements Serializable {

    private static final long serialVersionUID = -3259317466829829409L;

    private String nome;
    private String nomeCargo;
    private String nomeUnidade;

    public FuncionarioDTO(String nome, String nomeCargo, String nomeUnidade){
        this.nome = nome;
        this.nomeCargo = nomeCargo;
        this.nomeUnidade = nomeUnidade;
    }

}
