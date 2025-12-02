package Java.IO.NIO.Persistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        FilePersistence persistence = new NIOFilePersistence("user.csv");
        System.out.println("Criando um arquivo ->");
        System.out.println("===============================================");
        System.out.println(persistence.write("Guilhermo;guilhermo@varela.com;19/09/09"));
        System.out.println("===============================================");
        System.out.println(persistence.write("Agustin;agustin@rossi.com;23/11/99"));
        System.out.println("===============================================");
        System.out.println(persistence.write("Aila;aila@aila.com;03/10/25"));
        System.out.println("===============================================");
        System.out.println(persistence.findAll());
        System.out.println("===============================================");
        System.out.println(persistence.findBy("aila@"));
        System.out.println("===============================================");
        System.out.println(persistence.findBy("agustin@"));
        System.out.println("===============================================");
        System.out.println(persistence.remove("guilhermo@varela"));
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println(persistence.replace("@aila.com","@branco.br"));
        System.out.println("===============================================");
        System.out.println(persistence.replace("23/11/99", "29/9/99"));
        System.out.println("===============================================");


//        IO TESTS ->
//        FilePersistence persistence = new IOFilePersistence("user.csv");
//        System.out.println("===============================================");
//        System.out.println(persistence.write("Bernardo;contato.bernardomecabo@gmail.com;18/05/2005"));
//        System.out.println("===============================================");
//        System.out.println(persistence.write("Arrascaeta;giorgian@arrasca.com;19/09/2002"));
//        System.out.println("===============================================");
//        System.out.println(persistence.write("Danilo;danilo@flamengo.com;29/11/2025"));
//        System.out.println("===============================================");
//        System.out.println(persistence.findAll());
//        System.out.println("===============================================");
//        System.out.println(persistence.remove("Danilo"));
//        System.out.println("===============================================");
//        System.out.println(persistence.findBy("Bernardo"));
//        System.out.println("===============================================");
//        System.out.println(persistence.findBy("Arrascaeta"));
//        System.out.println("===============================================");


    }
}
