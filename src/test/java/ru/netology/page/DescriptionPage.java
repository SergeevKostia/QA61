package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DescriptionPage {
    private final SelenideElement title = $$("h2.heading").find(exactText("Путешествие дня"));
    private final SelenideElement buttonBuy = $$("button").find(text("Купить"));
    private final SelenideElement buttonBuyInCredit = $$("button").find((text("Купить в кредит")));

    public DescriptionPage() {
        title.shouldBe(visible);
        buttonBuy.shouldBe(visible);
        buttonBuyInCredit.shouldBe(visible);
    }

    @SneakyThrows
    public CardPage chooseCardPayment() {
        buttonBuy.click();
        return new CardPage();
    }

    public CardPage chooseCreditPayment() {
        buttonBuyInCredit.click();
        return new CardPage();
    }
}
