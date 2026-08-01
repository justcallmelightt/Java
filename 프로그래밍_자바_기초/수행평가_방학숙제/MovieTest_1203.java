// 1203 권율

import java.util.Scanner;

/**
 * [프로그래밍 자바 기초] - 자바 프로그래밍 수행평가
 *
 * 문제명: Movie 클래스 - 영화 목록 출력 (MovieTest_1203.java)
 *
 * 문제 조건 및 학습 목표:
 * 1. [조건 1] 영화 제목, 감독명, 상영시간을 필드로 가지는 Movie 클래스 작성
 * 2. [조건 1] 영화 정보를 한 줄로 출력하는 메소드 작성
 * 3. [조건 2] 5개의 영화 정보를 입력받아 Movie 객체 생성
 * 4. [조건 3] 생성자를 사용하여 객체의 모든 필드 초기화
 * 5. [조건 4] 모든 영화 정보를 목록으로 출력하고 총 상영시간 계산
 * 6. Scanner, 클래스, 객체, 생성자, 메소드와 객체 배열 사용 방법 학습
 *
 * 작성자: 미림마이스터고등학교 뉴미디어소프트웨어과 1203 권율
 */

// 1. [조건 1] 영화 한 편의 정보를 저장하기 위한 Movie 클래스
class Movie {
    // 영화 제목, 감독명, 상영시간을 저장하는 멤버 변수(필드)
    String title;
    String director;
    int runningTime;

    // 2. [조건 3] 객체를 생성할 때 전달받은 값으로 모든 필드를 초기화하는 생성자
    Movie(String title, String director, int runningTime) {
        this.title = title;
        this.director = director;
        this.runningTime = runningTime;
    }

    // 3. [조건 1] 한 편의 영화 정보를 한 줄로 출력하는 메소드
    void printInfo() {
        System.out.println(title + "\t" + director + "\t" + runningTime);
    }
}

public class MovieTest_1203 {
    public static void main(String[] args) {
        // 4. 키보드로 영화 정보를 입력받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 5. [조건 2] 5개의 Movie 객체를 저장할 객체 배열 생성
        Movie[] movies = new Movie[5];

        // 6. 반복문을 사용하여 영화 5편의 정보를 차례대로 입력받음
        for (int i = 0; i < movies.length; i++) {
            System.out.print("영화" + (i + 1) + " 제목 : ");
            String title = sc.nextLine();

            System.out.print("영화" + (i + 1) + " 감독명 : ");
            String director = sc.nextLine();

            System.out.print("영화" + (i + 1) + " 상영시간(분) : ");
            int runningTime = sc.nextInt();

            // nextInt() 뒤에 남아 있는 줄바꿈 문자를 제거함
            sc.nextLine();

            // 7. [조건 2, 3] 생성자를 호출하여 Movie 객체를 만들고 배열에 저장
            movies[i] = new Movie(title, director, runningTime);
        }

        // 8. 영화 목록의 위쪽 구분선과 항목 이름 출력
        System.out.println("─────────────────────");
        System.out.println("영화제목\t감독명\t상영시간");

        // 모든 영화의 상영시간을 더하여 저장할 변수
        int totalRunningTime = 0;

        // 9. [조건 4] 객체 배열에 저장된 모든 영화 정보를 한 줄씩 출력
        for (int i = 0; i < movies.length; i++) {
            movies[i].printInfo();
            totalRunningTime += movies[i].runningTime;
        }

        // 10. [조건 4] 아래쪽 구분선과 총 상영시간 출력
        System.out.println("─────────────────────");
        System.out.println("총 상영시간 : " + totalRunningTime + "분");

        // Resource leak 방지를 위해 사용이 끝난 Scanner 객체 해제
        sc.close();
    }
}
