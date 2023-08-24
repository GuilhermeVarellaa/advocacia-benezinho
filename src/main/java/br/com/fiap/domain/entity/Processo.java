package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PROCESSO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NUM_PROCESSO", columnNames = {"NUM_PROCESSO"})
})



public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCESSO")
    @SequenceGenerator(name = "SQ_PROCESSO", sequenceName = "SQ_PROCESSO")
    @Column(name = "ID_PROCESSO")
    private Long id;


    @Column(name = "NUM_PROCESSO")
    private String numero;


    private Boolean proBono;

    @ManyToOne
    private Advogado advogado;

    @ManyToOne
    private TipoDeAcao tipoDeAcao;


    public Processo() {
    }

    public Processo(Long id, String numero, Boolean proBono, Advogado advogado, TipoDeAcao tipoDeAcao) {
        this.id = id;
        this.numero = numero;
        this.proBono = proBono;
        this.advogado = advogado;
        this.tipoDeAcao = tipoDeAcao;
    }

    public Long getId() {
        return id;
    }

    public Processo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Processo setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public Boolean getProBono() {
        return proBono;
    }

    public Processo setProBono(Boolean proBono) {
        this.proBono = proBono;
        return this;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public Processo setAdvogado(Advogado advogado) {
        this.advogado = advogado;
        return this;
    }

    public TipoDeAcao getTipoDeAcao() {
        return tipoDeAcao;
    }

    public Processo setTipoDeAcao(TipoDeAcao tipoDeAcao) {
        this.tipoDeAcao = tipoDeAcao;
        return this;
    }


    @Override
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", proBono=" + proBono +
                ", advogado=" + advogado +
                ", tipoDeAcao=" + tipoDeAcao +
                '}';
    }
}
