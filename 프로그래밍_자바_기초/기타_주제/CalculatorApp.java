package calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorApp extends JFrame {

    private final Calculator calculator = new Calculator();

    private JTextField fieldA;
    private JTextField fieldB;
    private JLabel labelResult;

    public CalculatorApp() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        buildUI();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void buildUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.setBackground(new Color(245, 245, 245));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        fieldA = createTextField();
        fieldB = createTextField();

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("첫 번째 숫자"), gbc);
        gbc.gridx = 1;
        panel.add(fieldA, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("두 번째 숫자"), gbc);
        gbc.gridx = 1;
        panel.add(fieldB, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 8, 0));
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(createButton("+", () -> calculate('+')));
        buttonPanel.add(createButton("-", () -> calculate('-')));
        buttonPanel.add(createButton("×", () -> calculate('*')));
        buttonPanel.add(createButton("÷", () -> calculate('/')));

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        labelResult = new JLabel("결과: ", SwingConstants.CENTER);
        labelResult.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        labelResult.setForeground(new Color(30, 100, 200));
        labelResult.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        gbc.gridy = 3;
        panel.add(labelResult, gbc);

        add(panel);
    }

    private void calculate(char op) {
        try {
            double a = Double.parseDouble(fieldA.getText().trim());
            double b = Double.parseDouble(fieldB.getText().trim());

            double result = switch (op) {
                case '+' -> calculator.add(a, b);
                case '-' -> calculator.subtract(a, b);
                case '*' -> calculator.multiply(a, b);
                case '/' -> calculator.divide(a, b);
                default  -> throw new IllegalArgumentException("알 수 없는 연산자");
            };

            if (result == (long) result) {
                labelResult.setText("결과: " + (long) result);
            } else {
                labelResult.setText("결과: " + result);
            }
            labelResult.setForeground(new Color(30, 100, 200));

        } catch (NumberFormatException e) {
            labelResult.setForeground(new Color(200, 50, 50));
            labelResult.setText("숫자를 입력해주세요.");
        } catch (ArithmeticException e) {
            labelResult.setForeground(new Color(200, 50, 50));
            labelResult.setText(e.getMessage());
        }
    }

    private JTextField createTextField() {
        JTextField field = new JTextField(12);
        field.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        field.setHorizontalAlignment(JTextField.RIGHT);
        return field;
    }

    private JButton createButton(String text, Runnable action) {
        JButton button = new JButton(text);
        button.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBackground(new Color(70, 130, 200));
        button.setForeground(Color.WHITE);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> action.run());
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorApp::new);
    }
}
