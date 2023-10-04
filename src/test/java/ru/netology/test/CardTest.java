package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.PaymentEntity;
import ru.netology.data.SQLHelper;
import ru.netology.page.CardPage;
import ru.netology.page.DescriptionPage;

import static com.codeborne.selenide.Selenide.open;

public class CardTest {
    DescriptionPage tour;
    CardPage card;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() {
        SQLHelper.cleanBD();
        open("http://localhost:8080");
        tour = new DescriptionPage();
        card = tour.chooseCardPayment();
    }

    @Test
    void shouldBeSuccessfulTourCard(){
        card.pay(DataHelper.cardNumberApproved());
        card.approved();
        PaymentEntity entity = SQLHelper.paymentEntity();
        Assertions.assertEquals("APPROVED", entity.getStatus());
    }
}
