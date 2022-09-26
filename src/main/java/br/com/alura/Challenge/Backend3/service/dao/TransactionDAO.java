package br.com.alura.Challenge.Backend3.service.dao;

import br.com.alura.Challenge.Backend3.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionDAO {

    @Autowired
    private TransactionRepository transactionRepository;

    public void saveAllTransactions(List<Transaction> transactions){
        this.transactionRepository.saveAll(transactions);
    }

    public void saveTransaction(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    public List<Transaction> selectAll() {
        return this.transactionRepository.findAll();
    }

    public List<Transaction> selectDateBetween(LocalDateTime start, LocalDateTime end) {
        return this.transactionRepository.findByDataHoraTransacaoBetween(start, end);
    }
}
