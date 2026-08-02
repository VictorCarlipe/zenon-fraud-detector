package br.com.zenon.fraud;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FraudAnalyzer {
    private List<Transaction> lista = new ArrayList<>();

    //Construtor da classe para trabalhar com streams
    public FraudAnalyzer (List<Transaction> lista){
        this.lista = lista;
    }

    //Quantidade de fraudes
    public long ManyFraud(){
        return lista.stream().filter(Transaction::isFraud).count();
    }

    //Top fraudes
    public List<Transaction> TopFraud(int size){
        return lista.stream().filter(Transaction::isFraud).sorted(Comparator.comparing(Transaction::amount).reversed()).limit(size).collect(Collectors.toList());
    }

    //Prejuizo estimado
    public BigDecimal TotalFraud(){
        return lista.stream().filter(Transaction::isFraud).map(Transaction::amount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //Mapa de tipo,quantidade de transações fraudulentas
    public Map<eType, Long> FraudPerTransaction(){
       return lista.stream().filter(Transaction::isFraud).collect(Collectors.groupingBy(Transaction::type, Collectors.counting()));
    }
}
