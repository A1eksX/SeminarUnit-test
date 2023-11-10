package database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
 * Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQLзапрос и возвращает результат.
 * Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
 * выполнения запроса и обработки результатов.
 */
class DataProcessorTest {
    @Test
    void testDB(){
        Database database = mock(Database.class);
        // чтобы отвечал на ЛЮБОЙ запрос (в данном случае строку) используем метод - anyString()
        when(database.query(anyString())).thenReturn(Arrays.asList("testA", "testB", "testC"));

        DataProcessor dataProcessor = new DataProcessor(database);
        // убедимся, что кол-во возвращаемых объектов совпадает с тем, что мы ожидаем (ожидаем 3 объекта - testA, testB, testC)
        assertThat(dataProcessor.processData("SELECT * FROM users WHERE username LIKE '%test%' ").size()).isEqualTo(3);
    }

}