package com.financial.analyzer;

/**
 * Application entry point that handles user interaction via JOptionPane
 * and coordinates the transaction analysis process.
 *
 * @author Axel Castañeda
 */
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter the maximum amount of transactions:");
        int limit = Integer.parseInt(input);
        TransactionAnalyzer analyzer = new TransactionAnalyzer(limit);
        String answer = "";

        do {
            String inputAmount = JOptionPane.showInputDialog("Enter the transaction amount:");
            double amount = Double.parseDouble(inputAmount);
            boolean exito = analyzer.recordAmount(amount);
            if (!exito) {
                JOptionPane.showMessageDialog(null, "Maximum capacity reached");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Successfully registered!!");
                answer = JOptionPane.showInputDialog(null, "Continue? [YES/NO]");
            }
        } while (!answer.equalsIgnoreCase("NO"));

        analyzer.printReport();
    }

}
