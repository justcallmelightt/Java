// ImportDemo.java
// 주제: import 문 - FQCN(전체 이름) 방식 vs import 문 방식

package pack01;

import java.util.Scanner;   // 클래스 이름을 지정하는 import (교재 형식: import 패키지 이름.클래스 이름;)
// import java.util.*;      // 패키지 전체를 가져오는 import (교재 형식: import 패키지 이름.*;)
                              // 지금은 안 쓰지만 형식 비교를 위해 주석으로 남겨둠

public class ImportDemo {

    public static void main(String[] args) {

        // ================================================================
        // 1. import 없이 - FQCN(Fully Qualified Class Name, 전체 이름)으로 직접 사용
        //    java.util.Scanner 처럼 패키지 이름부터 전부 다 써야 한다
        // ================================================================
        java.util.Scanner sc1 = new java.util.Scanner(System.in);
        // 문제점: 이 클래스를 쓸 때마다 매번 "java.util."을 붙여야 해서 코드가 길고 불편함


        // ================================================================
        // 2. import 문 사용 - 파일 상단에서 한 번만 선언하면
        //    이후로는 클래스 이름만으로 사용 가능
        // ================================================================
        Scanner sc2 = new Scanner(System.in);  // 위에서 import java.util.Scanner; 를 했기 때문에 가능
        // sc1과 sc2는 결국 같은 클래스(java.util.Scanner)다. 표기 방식만 다를 뿐 동작은 완전히 동일하다

        System.out.println("정수를 입력하세요:");
        int num = sc2.nextInt();
        System.out.println("입력값: " + num);

        System.out.println();


        // ================================================================
        // 3. import 패키지.클래스; 와 import 패키지.*; 의 차이
        // ================================================================
        // import java.util.Scanner;
        //   → Scanner 클래스 "하나만" 이름으로 사용할 수 있게 됨
        //
        // import java.util.*;
        //   → java.util 패키지 안의 모든 클래스(Scanner, Random, ArrayList 등)를
        //     이름만으로 사용할 수 있게 됨
        //
        // 실수하기 쉬운 부분:
        // import java.util.*; 는 java.util 패키지 "바로 아래"에 있는 클래스만 포함한다.
        // 하위 패키지인 java.util.concurrent 같은 곳은 별도로 import해야 한다.
        // (점(.)으로 구분된 디렉터리 계층 구조라서, * 은 한 단계 깊이만 커버함)


        // ================================================================
        // 4. 이름이 같은 클래스가 서로 다른 패키지에 있을 때 (import로 해결 안 되는 경우)
        // ================================================================
        // 대표적인 예: java.util.Date 와 java.sql.Date
        // 이름은 똑같이 "Date"지만 서로 다른 패키지에 있는 완전히 다른 클래스다
        //
        // import java.util.Date;
        // import java.sql.Date;      // 컴파일 오류! Date라는 이름이 중복돼서 어느 쪽인지 알 수 없음
        //
        // 해결 방법: 둘 중 하나만 import하고, 나머지 하나는 FQCN으로 직접 쓴다
        // import java.util.Date;             // 이제부터 Date = java.util.Date
        java.util.Date utilDate = new java.util.Date();   // FQCN으로 명시 (Date로만 써도 되지만 명확성을 위해 유지)
        // java.sql.Date sqlDate = ...        // java.sql 쪽이 필요하면 이렇게 FQCN으로 접근

        System.out.println("java.util.Date: " + utilDate);
    }
}
