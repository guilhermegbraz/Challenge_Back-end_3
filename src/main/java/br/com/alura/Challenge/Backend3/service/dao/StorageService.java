package br.com.alura.Challenge.Backend3.service.dao;

import br.com.alura.Challenge.Backend3.service.dao.TransactionDAO;
import br.com.alura.Challenge.Backend3.service.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class StorageService {

    @Autowired
    TransactionDAO transactionDAO;

    @Autowired
    Parser csvParser;

    public void storageData(InputStream csvFile) {
        csvParser.setCvsFile(csvFile);
        this.transactionDAO.saveAllTransactions(this.csvParser.getAllData());

    }


}
