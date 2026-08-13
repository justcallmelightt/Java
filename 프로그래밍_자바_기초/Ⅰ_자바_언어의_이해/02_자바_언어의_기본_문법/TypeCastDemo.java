public class TypeCastDemo {
    public static void main(String[] args) {
        byte bValue = 100;
        // 더 작은 자료형(byte)에서 큰 자료형(short)으로 평 변환이 일어나니, 부작용
        // 자동 형 변환이 일어남
        short sValue = bValue;
        int iValue = bValue;
        // 소괄호에다가 변환할 타입을 써서 변환하는 것을 "강제 형 변환"이라고 함
        sValue = (short) bValue;
        iValue = (int) bValue;

        int iValue2 = 100;
        byte bb = (byte) iValue2;
        short ss = (short) iValue2;

        System.out.println(bb);
        System.out.println(ss);
    }
}
