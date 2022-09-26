package br.com.alura.Challenge.Backend3.service.validation;

import br.com.alura.Challenge.Backend3.model.Transaction;
import br.com.alura.Challenge.Backend3.service.validation.exception.DataTransactionException;

import java.util.List;

public interface TransactionValidator {
    public void validar(List<Transaction> transactions) throws DataTransactionException;
}
