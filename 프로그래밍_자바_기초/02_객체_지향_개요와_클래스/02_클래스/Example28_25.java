void push(int value) {
    if (isFull()) {
        int newSize = data.length * 2;
        System.out.println("스택 크기 확장: " + data.length + " → " + newSize);
        int[] newData = new int[newSize];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    data[++top] = value;
}
