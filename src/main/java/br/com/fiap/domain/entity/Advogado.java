package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ADVOGADOS", uniqueConstraints = {
        @UniqueConstraint(name = "NM_ADVOGADOs", columnNames = "NUM_OAB")
})

public class Advogado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ADVOGADO")
    private Long id;

    @Column(name = "NM_ADVOGADO")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "NUM_OAB")
    @Column(name = "NUM_OAB")
    private String numeroOAB;


    @ManyToOne
    @JoinColumn(name = "NM_ESTADO")
    private Estado estado;

    public Advogado() {
    }

    public Advogado(Long id, String nome, String numeroOAB, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.numeroOAB = numeroOAB;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Advogado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Advogado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getNumeroOAB() {
        return numeroOAB;
    }

    public Advogado setNumeroOAB(String numeroOAB) {
        this.numeroOAB = numeroOAB;
        return this;
    }

    public Estado getEstado() {
        return estado;
    }

    public Advogado setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public String toString() {
        return "Advogado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroOAB='" + numeroOAB + '\'' +
                '}';
    }


}
