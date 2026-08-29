char c = 'A';
System.out.println(c);       // A  <- 문자로 인식 (단, 내부적으로는 숫자임)
System.out.println((int) c); // 65 <- 타입 변환을 하여 정수로 인식됨
