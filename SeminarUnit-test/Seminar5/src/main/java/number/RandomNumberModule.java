package number;

import java.util.Random;

public class RandomNumberModule {
    public int[] getRandomNumbers(int size){
        Random rnd = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = rnd.nextInt(100);
        }
        return result;
    }
}
