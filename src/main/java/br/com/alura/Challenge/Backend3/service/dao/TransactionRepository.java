package br.com.alura.Challenge.Backend3.service.dao;

import br.com.alura.Challenge.Backend3.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
