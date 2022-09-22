package br.com.alura.Challenge.Backend3.model;

import java.math.BigDecimal;


public class Transaction {

    private String bancoOrigem;
    private String agenciOrigem;
    private String contaOrigem;
    private String bancoDestino;
    private String agenciaDestino;
    private String contaDestino;
    private BigDecimal valorDaTransacao;
    private String dataHoraTransacao;

    public Transaction(String bancoOrigem, String agenciOrigem, String contaOrigem, String bancoDestino, String agenciaDestino, String contaDestino, BigDecimal valorDaTransacao, String dataHoraTransacao) {
        this.bancoOrigem = bancoOrigem;
        this.agenciOrigem = agenciOrigem;
        this.contaOrigem = contaOrigem;
        this.bancoDestino = bancoDestino;
        this.agenciaDestino = agenciaDestino;
        this.contaDestino = contaDestino;
        this.valorDaTransacao = valorDaTransacao;
        this.dataHoraTransacao = dataHoraTransacao;
    }

    public String getBancoOrigem() {
        return bancoOrigem;
    }

    public String getAgenciOrigem() {
        return agenciOrigem;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public String getBancoDestino() {
        return bancoDestino;
    }

    public String getAgenciaDestino() {
        return agenciaDestino;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "bancoOrigem='" + bancoOrigem + '\'' +
                ", agenciOrigem='" + agenciOrigem + '\'' +
                ", contaOrigem='" + contaOrigem + '\'' +
                ", bancoDestino='" + bancoDestino + '\'' +
                ", agenciaDestino='" + agenciaDestino + '\'' +
                ", contaDestino='" + contaDestino + '\'' +
                ", valorDaTransacao=" + valorDaTransacao +
                ", dataHoraTransacao='" + dataHoraTransacao + '\'' +
                '}';
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public BigDecimal getValorDaTransacao() {
        return valorDaTransacao;
    }

    public String getDataHoraTransacao() {
        return dataHoraTransacao;
    }
}
