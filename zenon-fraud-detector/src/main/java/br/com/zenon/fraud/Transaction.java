package br.com.zenon.fraud;

import java.math.BigDecimal;

public record Transaction(int step,
                          eType type,
                          BigDecimal amount,
                          TransactionCustomer oldTC,
                          TransactionCustomer newTC,
                          boolean isFraud,
                          boolean isFlaggedFraud) {

    @Override
    public String toString() {
        return "Transaction{" +
                "step=" + step +
                ", type=" + type +
                ", amount=" + amount +
                ", nameOrig=" + oldTC.name() +
                ", oldbalanceOrg=" + oldTC.BalanceOrg() +
                ", newbalanceOrig=" + newTC.BalanceOrg() +
                ", nameDest=" + newTC.name() +
                ", oldbalanceDest=" + oldTC.BalanceDest() +
                ", newbalanceDest=" + newTC.BalanceDest() +
                ", isFraud=" + isFraud +
                ", isFlaggedFraud=" + isFlaggedFraud +
                '}';
    }
}

