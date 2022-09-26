package br.com.alura.Challenge.Backend3.service.dao;

import br.com.alura.Challenge.Backend3.model.Transaction;
import br.com.alura.Challenge.Backend3.service.parser.Parser;
import br.com.alura.Challenge.Backend3.service.validation.NoDataValidation;
import br.com.alura.Challenge.Backend3.service.validation.TransactionDuplicatedValidation;
import br.com.alura.Challenge.Backend3.service.validation.TransactionValidator;
import br.com.alura.Challenge.Backend3.service.validation.exception.DataTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class StorageService {

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private Parser csvParser;

    public String storageData(InputStream csvFile) {
        csvParser.setCvsFile(csvFile);
        List<Transaction> transactions = this.csvParser.getAllData();
        try{
            validar(new NoDataValidation(), transactions);
            validar(new TransactionDuplicatedValidation(this.transactionDAO), transactions);

            System.out.println("\n\nVou fazer a inserção\n\n");
            this.transactionDAO.saveAllTransactions(transactions);

        } catch (DataTransactionException e) {
            return e.getMessage();
        }
        return "Arquivo importado com sucesso !";
    }

    private static void validar(TransactionValidator validation, List<Transaction> transactions) throws DataTransactionException {
        try{validation.validar(transactions);}
        catch (DataTransactionException exception) {
            throw exception;
        }
    }


}
