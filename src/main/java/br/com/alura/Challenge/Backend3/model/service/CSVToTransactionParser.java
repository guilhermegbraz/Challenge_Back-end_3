package br.com.alura.Challenge.Backend3.model.service;

import br.com.alura.Challenge.Backend3.model.Transaction;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CSVToTransactionParser {

    InputStream cvsFile;
    private int currentLine;

    public CSVToTransactionParser(){}

    public CSVToTransactionParser(InputStream csvFile) {
        this.cvsFile = csvFile;
        this.currentLine = 0;
    }

    public void setCvsFile(InputStream cvsFile) {
        this.cvsFile = cvsFile;
        this.currentLine = 0;
    }

    public InputStream getCvsFile() {
        return cvsFile;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        try (Scanner file = new Scanner(this.cvsFile)){

            while (file.hasNextLine()){
                try{Scanner line = new Scanner(file.nextLine());
                    line.useDelimiter(",");
                    Transaction tr = new Transaction(line.next(), line.next(), line.next(), line.next(), line.next(),
                            line.next(), new BigDecimal(line.next()), line.next());

                    transactions.add(tr);
                } catch (Exception e) {
                    System.out.println("Um dos itens não pode ser guardado pos havia dados faltantes");
                }
            }
        }

        return transactions;
    }
}
