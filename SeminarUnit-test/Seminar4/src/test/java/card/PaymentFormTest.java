package card;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.*;

class PaymentFormTest {

    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`, `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */
    @Test
    void testPaymentForm(){
//        CreditCard card = mock(CreditCard.class);
//        when(card.getCardNumber()).thenReturn("123321");
//        when(card.getCardHolder()).thenReturn("Test Human");
//        when(card.getExpiryDate()).thenReturn("05/25");
//        when(card.getCvv()).thenReturn("111");
//
//
//        PaymentForm paymentForm = new PaymentForm(card);
//        paymentForm.pay(100);
//        verify(card, times(1)).charge(100);
    // создали ненастоящую карту
    CreditCard card = mock(CreditCard.class);
    when(card.getCardNumber()).thenReturn("123321");
    when(card.getCardHolder()).thenReturn("asdf");
    when(card.getExpiryDate()).thenReturn("10/28");
    when(card.getCvv()).thenReturn("111");

    // создали форму оплаты и в качестве конструктора передаём туда сразу нашу карту - new PaymentForm(card)
    PaymentForm paymentForm = new PaymentForm(card);
    // теперь надо убедиться, что mock-объект может вызвать метод - charge, для этого вызываем метод .pay, передаём туда
    // какую-то сумму
    paymentForm.pay(100);
    // теперь надо убедиться, что списалось именно 100, для проверки вызываем метод - verify, и передаём туда mock-объект(нашу карту),
    // с которой будет списываться и указываем вторым параметром сколько раз будет выполняться этот метод (card), для
    // этого надо написать times(1) - где 1 - это кол-во выполнений.
    verify(card, times(1)).charge(100); // в .charge(100) указываем, сколько ДОЛЖНО списаться
    }



}