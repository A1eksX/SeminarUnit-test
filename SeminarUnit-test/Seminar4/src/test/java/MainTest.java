//package seminars.fourth;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;



import java.util.*;


class MainTest {

    /**
     * 4.0. Проверка работы Mockito
     */
     @Test
    public void simpleTest() {
        // Создаем мок
        List<String> mockedList = mock(List.class);

        // Используем мок
        mockedList.add("one");
        mockedList.clear();

        // Проверяем, что методы были вызваны
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    /**
     * 4.1. Создать мок-объект Iterator, настроить поведение так,
     * чтобы за два вызова next() Iterator вернул два слова  “Hello World”,
     * и проверить это поведение с помощью утверждений
     */
      @Test
      public void iteratorWillReturnHelloWorld() {
          // Arrange
          Iterator iteratorMock = mock(Iterator.class); // Mock-объект(заглушка), имитирующая поведение итератора(Iterator.class)
          when(iteratorMock.next()).thenReturn("Hello").thenReturn("World!"); // с помощью when задаём поведение
          // нашего mock-объекта, тут говорим, что должен ответить iteratorMock (.thenReturn("Hello") - это ответ)
          // когда вызывают метод iteratorMock.next() Т.е. дословно:
          // когда вызовут iteratorMock.next() верни .thenReturn("Hello") - тоже самое что и when(iteratorMock.next()).thenReturn("Hello")

          // Act
          String result = iteratorMock.next() + " " + iteratorMock.next();

          assertThat(result).isEqualTo("Hello World!");
      }

}