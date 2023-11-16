package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RandomNumberModuleTest {
    @Test
    public void testRandomIntArray(){
        RandomNumberModule randomNumberModule = new RandomNumberModule();

        assertThat(randomNumberModule.getRandomNumbers(10).length).isEqualTo(10); // .length добавили для того,
        // чтобы получить длину массива, без .length создан был бы ТОЛЬКО массив на 10 чисел
    }

}