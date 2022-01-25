package br.com.ivanfsilva.familybudget.domain.model.orcamento;

public enum Categoria {

    ALIMENTACAO("Alimentação"),
    SAUDE("Saúde"),
    MORADIA("Moradia"),
    TRANSPORTE("Transporte"),
    EDUCACAO("Educação"),
    LAZER("Lazer"),
    IMPREVISTOS("Imprevistos"),
    OUTRAS("Outras");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Categoria toEnum(String descrico) {
        if (descrico == null) {
            return Categoria.OUTRAS;
        }

        for (Categoria c : Categoria.values()) {
            if (descrico.equals(c.getDescricao())) {
                return c;
            }
        }

        throw new IllegalArgumentException("Categoria inválida");
    }
}
