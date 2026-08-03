package br.com.zenon.fraud;

import java.math.BigDecimal;

public record Transaction(int step,
                          eType type,
                          BigDecimal amount,
                          TransactionCustomer oldTC,
                          TransactionCustomer newTC,
                          boolean isFraud,
                          boolean isFlaggedFraud){

    public Transaction{

        if (step <= 0){
            throw new IllegalArgumentException("step deve ser maior que zero");
        }

        if (Double.parseDouble(amount.toString()) < 0){
            throw new IllegalArgumentException("a quantia não pode ser menor que zero");
        }
    }

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