package Study.Java;

import java.io.File;
import java.io.IOException;

public class FileInfoDemo {
    public static void main(String[] args) throws IOException { // main을 먼저 실행하기때문에 main에서 이 메서드는 IOException을 던질 수 있다면 아예 Crash다. 에러별로 구별할수있게 (예시: 제3자 서비스 - 에러가 발생했습니다. (403) 처럼 코드라도 보여주는, 다만 403은 HTTP 상태 코드이고 자바 예외) 만들어야하나 예외처리 학습용이기 때문에 안함.
        // data/io
        File directory = new File("data", "io");
        File file = new File(directory,"test.txt");
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("폴더를 만들 수 없습니다." + directory.getAbsolutePath()); // 실패 시(false 반환) 예외를 던져서 실패를 알리는 로직. mkdirs()는 실패해도 예외 없이 false만 반환하므로, 직접 IOException을 던져 실패를 알린다.
        }
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("파일을 만들 수 없습니다." + file.getAbsolutePath());
        }

        // 파일 정보 출력 관련 학습용 간단 로직
        System.out.println("절대 경로: " + file.getName());
        System.out.println("파일 이름: " + directory.getPath());
        System.out.println("존재 여부: " + file.getName());
        System.out.println("파일 여부: " + file.isFile());
        System.out.println("파일 크기: " + file.length());
    }
}
