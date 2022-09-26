package br.com.alura.Challenge.Backend3.service.validation;

import br.com.alura.Challenge.Backend3.model.Transaction;
import br.com.alura.Challenge.Backend3.service.validation.exception.DataTransactionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoDataValidation implements TransactionValidator {

    public void validar(List<Transaction> transactions) throws DataTransactionException {
        if(transactions.isEmpty()){
            throw new DataTransactionException("O arquivo de transações bancáias esta vazio");
        }
    }
}
