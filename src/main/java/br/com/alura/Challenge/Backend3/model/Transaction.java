package br.com.alura.Challenge.Backend3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bancoOrigem;
    private String agenciOrigem;
    private String contaOrigem;
    private String bancoDestino;
    private String agenciaDestino;
    private String contaDestino;
    private BigDecimal valorDaTransacao;
    private LocalDateTime dataHoraTransacao;

    public Transaction(){}
    public Transaction(String bancoOrigem, String agenciOrigem, String contaOrigem, String bancoDestino,
                       String agenciaDestino, String contaDestino, BigDecimal valorDaTransacao, LocalDateTime dataHoraTransacao) {
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

    public LocalDateTime getDataHoraTransacao() {
        return dataHoraTransacao;
    }
}
