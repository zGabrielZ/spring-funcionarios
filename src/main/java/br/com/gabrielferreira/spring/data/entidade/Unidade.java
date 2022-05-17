package br.com.gabrielferreira.spring.data.entidade;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UNIDADES")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"funcionarios"})
public class Unidade implements Serializable {

    private static final long serialVersionUID = 1460599333948231797L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "unidade",cascade = CascadeType.REMOVE)
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Unidade(Long id, String descricao, String endereco) {
        this.id = id;
        this.descricao = descricao;
        this.endereco = endereco;
    }
}
