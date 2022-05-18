package br.com.gabrielferreira.spring.data.entidade;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "FUNCIONARIOS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"cargo","unidade"})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 6156813811593956897L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf",nullable = false)
    private String cpf;

    @Column(name = "salario",nullable = false)
    private BigDecimal salario;

    @Column(name = "data_contratacao", nullable = false)
    private LocalDate dataContratacao;

    @JoinColumn(name = "cargo_id",foreignKey = @ForeignKey(name="cargo_fk"))
    @ManyToOne
    private Cargo cargo;

    @JoinColumn(name = "unidade_id",foreignKey = @ForeignKey(name="unidade_fk"))
    @ManyToOne
    private Unidade unidade;

    public Funcionario(Long id, String nome, String cpf, BigDecimal salario, LocalDate dataContratacao, Cargo cargo, Unidade unidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.unidade = unidade;
    }
}
