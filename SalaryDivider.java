
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SalaryDivider extends JFrame {
    private JTextField totalField, billsField, savingsField, foodField, funField;
    private JLabel resultBills, resultSavings, resultFood, resultFun, errorLabel;
    
    public SalaryDivider() {
        setTitle("Salary Divider");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel for input fields.
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.add(new JLabel("Total Salary:"));
        totalField = new JTextField();
        inputPanel.add(totalField);
        
        inputPanel.add(new JLabel("Bills (%):"));
        billsField = new JTextField();
        inputPanel.add(billsField);
        
        inputPanel.add(new JLabel("Savings (%):"));
        savingsField = new JTextField();
        inputPanel.add(savingsField);
        
        inputPanel.add(new JLabel("Food (%):"));
        foodField = new JTextField();
        inputPanel.add(foodField);
        
        inputPanel.add(new JLabel("Fun (%):"));
        funField = new JTextField();
        inputPanel.add(funField);
        
        JButton calculateButton = new JButton("Calculate");
        inputPanel.add(calculateButton);
        
        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        inputPanel.add(errorLabel);
        
        // Panel for results.
        JPanel resultPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Allocations"));
        resultPanel.add(new JLabel("Bills:"));
        resultBills = new JLabel();
        resultPanel.add(resultBills);
        
        resultPanel.add(new JLabel("Savings:"));
        resultSavings = new JLabel();
        resultPanel.add(resultSavings);
        
        resultPanel.add(new JLabel("Food:"));
        resultFood = new JLabel();
        resultPanel.add(resultFood);
        
        resultPanel.add(new JLabel("Fun:"));
        resultFun = new JLabel();
        resultPanel.add(resultFun);
        
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
        
        // Action to perform calculation.
        calculateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    double total = Double.parseDouble(totalField.getText());
                    double billsPercent = Double.parseDouble(billsField.getText());
                    double savingsPercent = Double.parseDouble(savingsField.getText());
                    double foodPercent = Double.parseDouble(foodField.getText());
                    double funPercent = Double.parseDouble(funField.getText());
                    
                    double sumPercent = billsPercent + savingsPercent + foodPercent + funPercent;
                    
                    if (sumPercent != 100) {
                        errorLabel.setText("Percentages must add up to 100.");
                        return;
                    }
                    errorLabel.setText("");
                    
                    resultBills.setText(String.format("$%.2f", total * billsPercent / 100));
                    resultSavings.setText(String.format("$%.2f", total * savingsPercent / 100));
                    resultFood.setText(String.format("$%.2f", total * foodPercent / 100));
                    resultFun.setText(String.format("$%.2f", total * funPercent / 100));
                    
                } catch (NumberFormatException ex) {
                    errorLabel.setText("Please enter valid numbers.");
                }
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new SalaryDivider().setVisible(true);
            }
        });
System.out.println("This is only to fix a commit issue.");
    }
}
