package br.com.zenon.fraud;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        Transaction t1 = new Transaction(1,
                eType.PAYMENT,
                new BigDecimal("9839.64"),
                new TransactionCustomer("C1231006815", new BigDecimal("170136.0"),  new BigDecimal("0.0")),
                 new TransactionCustomer("M1979787155", new BigDecimal("160296.36"),  new BigDecimal("0.0")),
                false,
                false);

        Transaction t2 = new Transaction(743,
                eType.CASH_OUT,
                new BigDecimal("850002.52"),
                new TransactionCustomer("C1280323807", new BigDecimal("850002.52"),  new BigDecimal("6510099.11")),
                new TransactionCustomer("C873221189", new BigDecimal("0.0"),  new BigDecimal("7360101.63")),
                true,
                false);

        System.out.println(t1);
        System.out.println(t2);
         */

        List<Transaction> lista;
        TransactionIngestor ti = new TransactionIngestor();
        lista = ti.read("src/data/PS_20174392719_1491204439457_log.csv");

        for (int i = 0; i < 10; i++) {
            System.out.println(lista.get(i));
        }
    }
}