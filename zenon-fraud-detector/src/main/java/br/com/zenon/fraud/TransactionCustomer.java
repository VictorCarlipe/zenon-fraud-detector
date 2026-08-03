package br.com.zenon.fraud;

import java.math.BigDecimal;

public record TransactionCustomer(String name,
                                  BigDecimal BalanceOrg,
                                  BigDecimal BalanceDest) {

    public TransactionCustomer{
        if (Double.parseDouble(BalanceOrg.toString()) < 0){
            throw new IllegalArgumentException("saldo da conta de origem não pode ser menor que zero");
        }

        if (Double.parseDouble(BalanceDest.toString()) < 0){
            throw new IllegalArgumentException("saldo da conta de destino não pode ser menor que zero");
        }
    }
}