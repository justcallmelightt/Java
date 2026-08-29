BufferedWriter bw = new BufferedWriter(new FileWriter("unicode.txt"));
for (int c = 32; c <= 65535; c++) {
	bw.write(c);
}
bw.close();
System.out.println("완료");
