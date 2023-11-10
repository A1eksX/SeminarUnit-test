import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class EvenOddNumberTest {
    // Задание 1. Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли
    //переданное число четным или нечетным

    EvenOddNumber number;

    @BeforeEach
    void setup(){
        number = new EvenOddNumber();
    }
    @Test
    void checkEvenNumber(){
        int n = 10;
        assertThat(number.evenOddNumber(n)).isTrue();
    }
    @Test
    void checkOddNumber(){
      int n = 11;
        assertThat(number.evenOddNumber(n)).isFalse();
    }
    // Задание 2. Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли
    //переданное число в интервал (25;100)
    @ParameterizedTest
    @ValueSource(ints = { 26, 50, 99})
    void numberInIntervalTest(int n){
        assertThat(number.numberInInterval(n)).isTrue();
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 25, 100, 101})
    void numberNotInIntervalTest(int n){
        assertThat(number.numberInInterval(n)).isFalse();
    }
}
