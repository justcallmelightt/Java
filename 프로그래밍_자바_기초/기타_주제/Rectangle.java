/**
 * 직사각형을 나타내는 클래스.
 *
 * @author 작성자이름
 * @version 1.0
 */
public class Rectangle {

    private double width;
    private double height;

    /**
     * 너비와 높이를 받아 Rectangle 객체를 생성한다.
     *
     * @param width  직사각형의 너비 (양수여야 함)
     * @param height 직사각형의 높이 (양수여야 함)
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * 직사각형의 넓이를 반환한다.
     *
     * @return 너비 × 높이
     */
    public double getArea() {
        return width * height;
    }

    /**
     * 직사각형의 둘레를 반환한다.
     *
     * @return (너비 + 높이) × 2
     */
    public double getPerimeter() {
        return (width + height) * 2;
    }

    /**
     * 이 직사각형이 정사각형인지 확인한다.
     *
     * @return 너비와 높이가 같으면 true, 다르면 false
     */
    public boolean isSquare() {
        return width == height;
    }
}
