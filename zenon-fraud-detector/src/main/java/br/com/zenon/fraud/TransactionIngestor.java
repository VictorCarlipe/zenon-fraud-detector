package br.com.zenon.fraud;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TransactionIngestor {

    public List<Transaction> read(String filename) {
        //retorno
        List<Transaction> lista = new ArrayList<>();

        //diretório
        Path path = Paths.get(filename);

        //try-with-rosources(closable bfreader)
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))){

            //declaração de variáveis
            String lin;
            String[] col;
            int count = -1;

            do {
                //lê a próxima linha do arquivo
                lin = bufferedReader.readLine();

                if (lin != null) {

                    //se o count for >= zero já passou da primeira linha
                    if (count >= 0){

                        //aloca conteudo da linha em vetor de string
                        col = lin.split(",");

                        //constrói objetos com atributos da linha e adiciona à lista
                        lista.add(new Transaction(
                                Integer.parseInt(col[0]),
                                eType.valueOf(col[1]),
                                new BigDecimal(col[2]),
                                new TransactionCustomer(col[3], new BigDecimal(col[4]), new BigDecimal(col[5])),
                                new TransactionCustomer(col[6], new BigDecimal(col[7]), new BigDecimal(col[8])),
                                col[9].equals("1"),
                                col[10].equals("1")));

                        count += 1;
                    } else {
                        //cabeçalho não deve contar
                        count = 0;
                    }
                }
            //se já leu 1000 linhas ou caso não tenha mais conteudo para ler
            } while (count < 1001 && lin != null);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao tentar ler o arquivo:" + filename);
        }

        return lista;
    }
}