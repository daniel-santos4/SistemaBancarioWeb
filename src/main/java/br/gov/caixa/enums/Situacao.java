package br.gov.caixa.enums;

public enum Situacao {
    INATIVO("INATIVO(A)"),
    ATIVO("ATIVO(A)");

    public final String descricao;
    private Situacao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
