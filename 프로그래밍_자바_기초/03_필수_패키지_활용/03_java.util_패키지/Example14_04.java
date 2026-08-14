import java.util.concurrent.ThreadLocalRandom;

int dice = ThreadLocalRandom.current().nextInt(1, 7); // 1~6
double randDouble = ThreadLocalRandom.current().nextDouble();
