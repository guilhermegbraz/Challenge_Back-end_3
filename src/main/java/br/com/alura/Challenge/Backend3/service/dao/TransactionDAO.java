package br.com.alura.Challenge.Backend3.service.dao;

import br.com.alura.Challenge.Backend3.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDAO {

    @Autowired
    TransactionRepository transactionRepository;

    public void saveAllTransactions(List<Transaction> transactions){
        this.transactionRepository.saveAll(transactions);
    }

    public void saveTransaction(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }
}
