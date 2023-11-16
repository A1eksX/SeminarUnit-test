package number;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class IntegrationNumbersTest {
    @Test
    public void testIntegrationsNumbers(){
        RandomNumberModule randomNumberModule = new RandomNumberModule(); // создаём первый объект
        MaxNumberModule maxNumberModule = new MaxNumberModule();    // создаём второй объект

        int [] testArray = randomNumberModule.getRandomNumbers(15); // создаём массив
        int max = maxNumberModule.getMax(testArray); // находим максимальное число в массиве используя maxNumberModule

        Arrays.sort(testArray); // сортируем массив, чтобы максимальное число было в конце массива

        assertThat(max).isEqualTo( testArray [testArray.length-1] ); // сравниваем с последним элементом массива
    }
}
