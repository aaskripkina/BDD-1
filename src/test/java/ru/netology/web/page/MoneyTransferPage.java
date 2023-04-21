package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private SelenideElement reloadButton = $("[data-test-id=action-reload]");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");
    private SelenideElement cancelButton = $("[data-test-id=action-cancel]");
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromField = $("[data-test-id=from] input");

    private SelenideElement errorNotification = $("[data-test-id=error-notification]");


    public DashboardPage transferMoney ( int sumTransfer, String numberTransferCard){

        amountField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        amountField.setValue(Integer.toString(sumTransfer));
        fromField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        fromField.setValue(numberTransferCard);
        transferButton.click();
        return new DashboardPage();
    }

    public void getErrorNotification() {
        errorNotification.shouldBe(Condition.visible);
        errorNotification.shouldHave(Condition.exactText("Ошибка\n" + "Ошибка! Произошла ошибка"));
    }
}