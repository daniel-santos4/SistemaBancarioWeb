package br.gov.caixa.entity;

import br.gov.caixa.enums.Situacao;
import br.gov.caixa.enums.TipoCliente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente {
    @Id
    private String id;
    private String nome;
    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    @Enumerated(EnumType.ORDINAL)
    private Situacao status;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Conta> contas;

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.replace(".", "")
                    .replace("-", "")
                    .replace("/", "");
        while (this.id.startsWith("0")) {
            this.id = this.id.substring(1);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Situacao getStatus() {
        return status;
    }

    public void setStatus(Situacao status) {
        this.status = status;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
