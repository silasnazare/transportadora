package br.edu.ifma.si.lbd.transportadora.service;

import java.math.BigDecimal;

public class FreteFiltro {

    private BigDecimal maiorValor;
    private BigDecimal menorValor;
    private String cidadeOrigem;
    private String cidadeDestino;
    private String nomeCliente;

    public BigDecimal getMaiorValor() {
        return maiorValor;
    }

    public void setMaiorValor(BigDecimal maiorValor) {
        this.maiorValor = maiorValor;
    }

    public BigDecimal getMenorValor() {
        return menorValor;
    }

    public void setMenorValor(BigDecimal menorValor) {
        this.menorValor = menorValor;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}
