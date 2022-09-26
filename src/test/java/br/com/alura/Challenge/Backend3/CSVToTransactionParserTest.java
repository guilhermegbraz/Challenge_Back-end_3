package br.com.alura.Challenge.Backend3;

import br.com.alura.Challenge.Backend3.model.Transaction;
import br.com.alura.Challenge.Backend3.service.parser.CSVToTransactionParser;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;



public class CSVToTransactionParserTest {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = new FileInputStream("exemplo.csv");
        CSVToTransactionParser parser = new CSVToTransactionParser(is);
        List<Transaction> lista =  parser.getAllData();
        System.out.println(lista);

    }
}
