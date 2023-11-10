package message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
recipient), который отправляет сообщение получателю.
Вам необходимо проверить правильность работы класса NotificationService, который использует
MessageService для отправки уведомлений.

 */

class NotificationServiceTest {
    @Test
    void testSendMessage(){
        MessageService messageService = mock(MessageService.class); // создаём заглушку сервиса сообщений

        NotificationService notificationService = new NotificationService(messageService); // тут создаём сервис notificationService
        // и в при создании указываем, что сообщения из сервиса notificationService будут уходить в сервис messageService
        notificationService.sendNotification("test","admin"); // теперь из notificationService отправляем данные в наш messageService для проверки
        verify(messageService, times(1)).sendMessage("test", "admin"); // проверяем, пришли ли указанные нами данные в messageService или нет
    }
    // т.о. проверяем правильно ли метод sendNotification из класса NotificationService отправляет сообщения
}