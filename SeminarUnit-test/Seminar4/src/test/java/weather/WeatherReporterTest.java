package weather;


import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;
/**
Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
обращающийся к внешнему API для получения информации о текущей температуре.
Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
Создайте мок-объект для WeatherService с использованием Mockito.
 */
class WeatherReporterTest {
    @Test
    void testReporter(){
        WeatherService service = mock(WeatherService.class);
        when(service.getCurrentTemperature()).thenReturn(25);

        WeatherReporter reporter = new WeatherReporter(service);
        assertThat(reporter.generateReport()).isEqualTo("Текущая температура: 25 градусов.");
    }

}