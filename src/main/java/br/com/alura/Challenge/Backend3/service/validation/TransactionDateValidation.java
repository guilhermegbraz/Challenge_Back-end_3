package br.com.alura.Challenge.Backend3.service.validation;

import br.com.alura.Challenge.Backend3.model.Transaction;
import br.com.alura.Challenge.Backend3.service.validation.exception.DataTransactionException;

import java.time.LocalDate;
import java.util.List;

public class TransactionDateValidation implements TransactionValidator{

    LocalDate transactionsDate;
    @Override
    public void validar(List<Transaction> transactions) throws DataTransactionException {
        this.transactionsDate = transactions.get(0).getDataHoraTransacao().toLocalDate();

        transactions.forEach(transaction -> {
            if(!transaction.getDataHoraTransacao().toLocalDate().equals(transactionsDate)){
                transactions.remove(transaction);
            }});

    }
}
