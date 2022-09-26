package br.com.alura.Challenge.Backend3.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Data_Transacoes")
public class DateOfTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHoraImportacao;
    private LocalDate dataTransacao;

    public DateOfTransaction(LocalDateTime dataHoraImportacao, LocalDate dataTransacao) {
        this.dataHoraImportacao = dataHoraImportacao;
        this.dataTransacao = dataTransacao;
    }
    public DateOfTransaction(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraImportacao() {
        return dataHoraImportacao;
    }

    public void setDataHoraImportacao(LocalDateTime dataHoraImportacao) {
        this.dataHoraImportacao = dataHoraImportacao;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
