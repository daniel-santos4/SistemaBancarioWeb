package br.gov.caixa.dto.request;

import br.gov.caixa.enums.TipoCliente;

public class ClienteRequestDto {
    private String id;
    private String nome;
    private TipoCliente tipo;

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
}
