package br.com.alura.Challenge.Backend3.service.dao;

import br.com.alura.Challenge.Backend3.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByDataHoraTransacaoBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
