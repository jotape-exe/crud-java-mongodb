/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author João Pedro
 */
public class Conexao {
    
    private final MongoClient mongoClient;
    private final MongoDatabase banco;
    
    public Conexao(){
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        banco = mongoClient.getDatabase("db_fornecedores");
        System.out.println("Conectado ao MongoDB ");
    }
    
    public MongoDatabase getbanco(){
        return banco;
    }
}

