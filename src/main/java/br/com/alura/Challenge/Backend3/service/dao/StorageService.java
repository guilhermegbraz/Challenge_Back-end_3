package br.com.alura.Challenge.Backend3.service.dao;

import br.com.alura.Challenge.Backend3.model.DateOfTransaction;
import br.com.alura.Challenge.Backend3.model.Transaction;
import br.com.alura.Challenge.Backend3.service.parser.Parser;
import br.com.alura.Challenge.Backend3.service.validation.NoDataValidation;
import br.com.alura.Challenge.Backend3.service.validation.TransactionDateValidation;
import br.com.alura.Challenge.Backend3.service.validation.TransactionDuplicatedValidation;
import br.com.alura.Challenge.Backend3.service.validation.TransactionValidator;
import br.com.alura.Challenge.Backend3.service.validation.exception.DataTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StorageService {

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private Parser csvParser;

    @Autowired
    private DateOfTransactionDAO transactionDateDAO;


    public String storageTransactionData(InputStream csvFile) {
        csvParser.setCvsFile(csvFile);
        List<Transaction> transactions = this.csvParser.getAllData();

        try{
            validar(transactions);
            this.transactionDAO.saveAllTransactions(transactions);
            storageDateOfDBAccess(transactions.get(0).getDataHoraTransacao().toLocalDate());

        } catch (DataTransactionException e) {
            return e.getMessage();
        }
        return "Arquivo importado com sucesso !";
    }

    private void validar(List<Transaction> transactions) throws DataTransactionException {
        List<TransactionValidator> validations = List.of(new NoDataValidation(),
                new TransactionDuplicatedValidation(this.transactionDAO),
                new TransactionDateValidation());

      for(TransactionValidator validation : validations) {
          validation.validar(transactions);
      }
    }


    private void storageDateOfDBAccess(LocalDate dateOfStorage) {
        this.transactionDateDAO.saveDate(new DateOfTransaction(LocalDateTime.now(),dateOfStorage));
    }

}
