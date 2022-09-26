package br.com.alura.Challenge.Backend3.service.dao;

import br.com.alura.Challenge.Backend3.model.DateOfTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateOfTransactionDAO {

    @Autowired
    private DateOfTransactionRepository dateOfTransactionRepository;

    public void saveDate(DateOfTransaction dot) {
        this.dateOfTransactionRepository.save(dot);
    }

    public List<DateOfTransaction> selectAll() {
        return this.dateOfTransactionRepository.findAll();
    }
}
