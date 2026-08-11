# JAR 파일 만들기

- 원문: http://yubs.online/java/%EA%B8%B0%ED%83%80-%EC%A3%BC%EC%A0%9C/04_jar-%ED%8C%8C%EC%9D%BC-export-%EB%B0%8F-%EC%8B%A4%ED%96%89-%ED%8C%8C%EC%9D%BC-%EB%A7%8C%EB%93%A4%EA%B8%B0.html
- 용도: yubs.online 수업 페이지의 코드 블록을 원문 순서대로 보존한 학습 자료입니다.
- 실행 가능한 예제는 같은 단원의 Java 파일을 우선 참고하세요.

## 코드 블록 1

```text
친구 컴퓨터에서 실행하려면?

기존 방식 : 프로젝트 폴더 전체 복사 → IntelliJ 설치 → 열기 → 실행
JAR 방식  : jar 파일 하나 복사 → java -jar 명령어 한 줄
```

## 코드 블록 2

```text
CalcDemo/
└── src/
    └── calculator/          ← 패키지 (소문자)
        ├── Calculator.java      ← 사칙연산 로직
        └── CalculatorApp.java   ← GUI + main
```

## 코드 블록 3

```text
package calculator;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }
}
```

## 코드 블록 4

```text
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
```

## 코드 블록 5

```text
CalcDemo/
└── out/
    └── artifacts/
        └── CalcDemo_jar/
            └── CalcDemo.jar   ← 이 파일
```

## 코드 블록 6

```text
java -jar out/artifacts/CalcDemo_jar/CalcDemo.jar
```

## 코드 블록 7

```text
java -jar calculator.jar
```

## 코드 블록 8

```text
candle /?
```

## 코드 블록 9

```text
jpackage --input out/artifacts/CalcDemo_jar ^
         --main-jar CalcDemo.jar ^
         --name Calculator ^
         --type exe
```

## 코드 블록 10

```text
jpackage --input out/artifacts/CalcDemo_jar --main-jar CalcDemo.jar --name Calculator --type exe --java-options "-Dfile.encoding=UTF-8"
```

## 코드 블록 11

```text
C:\Program Files\Calculator\
├── app\                  ← 앱 클래스 파일
├── runtime\              ← 번들된 JRE
└── Calculator.exe        ← 실행 파일
```
