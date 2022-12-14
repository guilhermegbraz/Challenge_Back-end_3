package br.com.alura.Challenge.Backend3.service.validation;

import br.com.alura.Challenge.Backend3.model.Transaction;
import br.com.alura.Challenge.Backend3.service.dao.TransactionDAO;
import br.com.alura.Challenge.Backend3.service.validation.exception.DataTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionDuplicatedValidation implements TransactionValidator{

    @Autowired
    private TransactionDAO transactionDAO;

    public TransactionDAO getTransactionDAO() {
        return transactionDAO;
    }
    public TransactionDuplicatedValidation() {

    }
    public TransactionDuplicatedValidation(TransactionDAO dao) {
        this.transactionDAO = dao;
    }

    public void setTransactionDAO(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public void validar(List<Transaction> transactions) throws DataTransactionException {

        for (Transaction transaction : transactions) {

            LocalDate day = transaction.getDataHoraTransacao().toLocalDate();
            boolean dateAllreadyImported = !(transactionDAO.selectDateBetween(
                    day.atStartOfDay(), day.atTime(23, 59, 59)).isEmpty());

            if(dateAllreadyImported){
                throw new DataTransactionException("Os dados referentes a esse dia ja foram importados");
            }
        }
    }
}
