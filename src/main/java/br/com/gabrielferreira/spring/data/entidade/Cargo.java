package br.com.gabrielferreira.spring.data.entidade;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARGOS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"funcionarios"})
public class Cargo implements Serializable {

    private static final long serialVersionUID = -4550048744344787322L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,mappedBy = "cargo")
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Cargo(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
