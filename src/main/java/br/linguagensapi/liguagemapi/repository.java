package br.linguagensapi.liguagemapi;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface repository extends MongoRepository <linguagem , String> {
    List<linguagem> findByOrderByRanking();
    
}
