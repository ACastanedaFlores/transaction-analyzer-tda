package com.financial.analyzer;

/**
 * Manages and analyzes a fixed batch of financial transactions.
 * 
 * @author Axel Castañeda
 */
import javax.swing.JOptionPane;

public class TransactionAnalyzer {

    private double amounts[];
    private int cont;

    public TransactionAnalyzer(int limiteMaximo) {
        this.amounts = new double[limiteMaximo];
        this.cont = 0;
    }

    public boolean recordAmount(double monto) {
        if (cont < amounts.length) {
            amounts[cont] = monto;
            cont++;
            return true;
        } else {
            return false;
        }

    }

    public double calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < cont; i++) {
            total += amounts[i];
        }
        return total;
    }

    public double calculateAverage() {
        if (cont == 0) {
            return 0.0;
        } else {
            double average = calculateTotal() / cont;
            return average;
        }
    }

    public void printReport() {
        String textoReporte = "==== FINANCIAL REPORT ====\n"
                + "Total Amount: $" + calculateTotal() + "\n"
                + "Average: $" + calculateAverage();
        JOptionPane.showMessageDialog(null, textoReporte, "Report", JOptionPane.INFORMATION_MESSAGE);
    }
}
