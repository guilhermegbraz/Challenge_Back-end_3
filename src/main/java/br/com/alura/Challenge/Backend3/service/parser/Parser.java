package br.com.alura.Challenge.Backend3.service.parser;

import java.io.InputStream;
import java.util.List;

public interface Parser<T> {
    List<T> getAllData();
    void setCvsFile(InputStream cvsFile);
}
