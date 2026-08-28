import java.awt.Dimension;
import javax.swing.*; // Dimension 사용을 위한 import 추가

public class GUIEx1 {
    public static void main(String[] args) {
        // 람다식 (중괄호 { } 추가)
        SwingUtilities.invokeLater(() -> {
            // 제목이 "Test"인 창을 만든다.
            JFrame frame = new JFrame("Test_Window");
            // X 버튼을 누르면 꺼지게 하기
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 화면에 사용할 빈 패널을 만든다.
            JPanel contentPanel = new JPanel();

            // 실제 컴포넌트가 위치할 Panel
            JPanel panel = new JPanel();
            // 레이아웃 매니저 설정 (우리는 null만 된다고 생각하기 -> AbsoluteLayout)
            panel.setLayout(null);
            // 사이즈 설정 (width, height)
            panel.setPreferredSize(new Dimension(1800, 500));

            // Panel 설정 (추가) - 대소문자 구분 (Panel -> panel)
            frame.setContentPane(panel);
            // 사이즈 맞추기 (무조건 쓰기)
            frame.pack();
            // 리사이즈 불가
            frame.setResizable(false);
            // 창의 화면 중앙의 배치
            frame.setLocationRelativeTo(null);
            // 창 보여주기
            frame.setVisible(true);
        }); // 람다식 및 invokeLater 닫기 괄호 추가
    }
}
