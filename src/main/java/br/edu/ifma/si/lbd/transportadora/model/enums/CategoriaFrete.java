package br.edu.ifma.si.lbd.transportadora.model.enums;

public enum CategoriaFrete {

    RAPIDO("Rápido"),SUPERRAPIDO("Super-rápido"), NORMAL("Normal");

    private String categoria;

    CategoriaFrete(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

}
