public class DebugWatchDemo {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 9, 2, 7};

        // 버블정렬: 인접한 두 값을 비교해서 큰 값을 오른쪽으로 밀어내는 정렬
        // i: 몇 번째 패스인지 (패스가 끝날 때마다 가장 큰 값이 오른쪽에 확정됨)
        // j: 현재 비교 중인 위치 (arr[j]와 arr[j+1]을 비교)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 왼쪽 값이 더 크면 두 값의 위치를 맞바꿈 (swap)
                    int temp = arr[j];
                    arr[j] = arr[j + 1];    // 여기에 Breakpoint
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("정렬 완료");
    }
}
