import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    // 3.1.
    SomeService service;

    @BeforeEach
    void setup(){
        service = new SomeService();
    }
    @ParameterizedTest
    @ValueSource(ints = {33, 6, 12, 3})
    void multipleThreeNotFiveReturnsFizz(int n) {
        assertThat(service.fizzBuzz(n)).isEqualTo("Fizz");
    }
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 25, 50})
    void multipleFiveNotThreeReturnsBuzz(int n) {
        assertThat(service.fizzBuzz(n)).isEqualTo("Buzz");
    }
    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60})
    void multipleFifteenNotFiveNotThreeReturnsFizzBuzz(int n) {
        assertThat(service.fizzBuzz(n)).isEqualTo("FizzBuzz");
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7})
    void multipleNotFifteenNotFiveNotThreeReturnsOriginNumber(int n) {
        assertThat(service.fizzBuzz(n)).isEqualTo(String.valueOf(n));
    }

// 3.2 кол-во тестов определяет кол-во return'ов
    @Test   // тест, если первый элемент равен 6
    void firstIsSix(){
        int [] arr = {6, 2, 3, 4, 5, 1};
        assertThat(service.firstLast6(arr)).isTrue();
    }
    @Test   // тест, если последний элемент равен 6
    void LastIsSix(){
        int [] arr = {1, 2, 3, 4, 5, 6};
        assertThat(service.firstLast6(arr)).isTrue();
    }
    @Test   // тест, если ни первый, ни последний элемент не равен 6
    void firstAndLastIsNoSix(){
        int [] arr = {1, 2, 3, 4, 5, 8};
        assertThat(service.firstLast6(arr)).isFalse();
    }

    // 3.4
    @Test
    void OneThirteenTestLuckySum (){
        assertThat(service.luckySum(13, 5, 4)).isEqualTo(9);
        assertThat(service.luckySum(5, 13, 4)).isEqualTo(9);
        assertThat(service.luckySum(4, 5, 13)).isEqualTo(9);
    }
    @Test
    void TwoThirteenTestLuckySum (){
        assertThat(service.luckySum(13, 13, 4)).isEqualTo(4);
        assertThat(service.luckySum(4, 13, 13)).isEqualTo(4);
        assertThat(service.luckySum(13, 4, 13)).isEqualTo(4);
    }
    @Test
    void ThreeThirteenTestLuckySum (){
        assertThat(service.luckySum(13, 13, 13)).isEqualTo(0);
    }

    @Test
    void normalLuckySum (){
        assertThat(service.luckySum(1, 2, 3)).isEqualTo(6);
    }


}
