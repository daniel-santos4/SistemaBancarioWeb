package br.gov.caixa.dto.response;

import br.gov.caixa.enums.Situacao;
import br.gov.caixa.enums.TipoCliente;

import java.util.List;

public class ClienteResponseDto {
    private String id;
    private String nome;
    private TipoCliente tipo;
    private Situacao status;
    private List<ContaResponseDto> contas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public Situacao getStatus() {
        return status;
    }

    public void setStatus(Situacao status) {
        this.status = status;
    }

    public List<ContaResponseDto> getContas() {
        return contas;
    }

    public void setContas(List<ContaResponseDto> contas) {
        this.contas = contas;
    }
}
