package br.edu.ifma.si.lbd.transportadora.model.enums;

public enum TipoVeiculo {

    MOTO("Moto"), CARRO("Carro"), CAMINHAO("Caminhão"), ONIBUS("Ônibus");

    private String tipo;

    TipoVeiculo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
