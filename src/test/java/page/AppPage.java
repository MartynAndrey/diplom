package page;

import data.CardInfo;

import java.time.Duration;
import java.util.List;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import org.openqa.selenium.Keys;

public class AppPage {
    private String appURL = System.getProperty("app.url");

    private SelenideElement pageHeader = $(".heading_size_l");

    private SelenideElement paymentButton = $$("button").find(exactText("Купить"));
    private SelenideElement creditButton = $$("button").find(exactText("Купить в кредит"));

    private SelenideElement paymentHeader = $$(".heading_size_m").find(exactText("Оплата по карте"));
    private SelenideElement creditHeader = $$(".heading_size_m").find(exactText("Кредит по данным карты"));

    private List<SelenideElement> fieldset = $$("fieldset input");
    private SelenideElement cardNumberField = fieldset.get(0);
    private SelenideElement cardMonthField = fieldset.get(1);
    private SelenideElement cardYearField = fieldset.get(2);
    private SelenideElement cardOwnerField = fieldset.get(3);
    private SelenideElement cardCvvField = fieldset.get(4);

    private SelenideElement subInvalidFormat = $$(".input__sub").find(exactText("Неверный формат"));
    private SelenideElement subCardExpired = $$(".input__sub").find(exactText("Истёк срок действия карты"));
    private SelenideElement subEmptyField = $$(".input__sub").find(exactText("Поле обязательно для заполнения"));
    private SelenideElement subInvalidDate = $$(".input__sub").find(exactText("Неверно указан срок действия карты"));

    private SelenideElement continueButton = $("fieldset button");

    private SelenideElement notification = $(".notification");

    private SelenideElement successMessage = $$(".notification__title").find(exactText("Успешно"));
    private SelenideElement errorMessage = $$(".notification__title").find(exactText("Ошибка"));

    private SelenideElement notificationSuccessCloser = $(".notification_status_ok button");
    private SelenideElement notificationErrorCloser = $(".notification_status_error button");

    public AppPage() {
        open(this.appURL);
        this.pageHeader.shouldBe(visible, Duration.ofSeconds(1000));
    }

    private void clearField(SelenideElement field) {
        if (!field.getValue().isEmpty()) {
            field.sendKeys(Keys.END);
            field.sendKeys(Keys.SHIFT, Keys.HOME);
            field.sendKeys(Keys.DELETE);
        }
    }

    public void startPayment() {
        this.paymentButton.click();
        this.paymentHeader.shouldBe(visible, Duration.ofSeconds(100));
    }

    public void startCredit(){
        this.creditButton.click();
        this.creditHeader.shouldBe(visible, Duration.ofSeconds(100));
    }

    public void setFields (CardInfo cardInfo) {
        clearField(this.cardNumberField);
        this.cardNumberField.setValue(cardInfo.getNumber());
        clearField(this.cardMonthField);
        this.cardMonthField.setValue(cardInfo.getMonth());
        clearField(this.cardYearField);
        this.cardYearField.setValue(cardInfo.getYear());
        clearField(this.cardOwnerField);
        this.cardOwnerField.setValue(cardInfo.getOwner());
        clearField(this.cardCvvField);
        this.cardCvvField.setValue(cardInfo.getCvv());

    }

    public void setCardNumber(String number) {
        clearField(this.cardNumberField);
        this.cardNumberField.setValue(number);
    }

    public void setCardMonth(String month) {
        clearField(this.cardMonthField);
        this.cardMonthField.setValue(month);
    }

    public void setCardYear(String year) {
        clearField(this.cardYearField);
        this.cardYearField.setValue(year);
    }

    public void setCardOwner(String owner) {
        clearField(this.cardOwnerField);
        this.cardOwnerField.setValue(owner);
    }

    public void setCardCVV(String cvv) {
        clearField(this.cardCvvField);
        this.cardCvvField.setValue(cvv);
    }

    public void clickContinueButton() {
        this.continueButton.click();
    }

    public void isVisibleSubInvalidFormat() {
        this.subInvalidFormat.shouldBe(visible);
        this.subCardExpired.shouldNotBe(visible);
        this.subEmptyField.shouldNotBe(visible);
        this.subInvalidDate.shouldNotBe(visible);
    }

    public void isVisibleSubCardExpired() {
        this.subInvalidFormat.shouldNotBe(visible);
        this.subCardExpired.shouldBe(visible);
        this.subEmptyField.shouldNotBe(visible);
        this.subInvalidDate.shouldNotBe(visible);
    }

    public void isVisibleSubEmptyField() {
        this.subInvalidFormat.shouldNotBe(visible);
        this.subCardExpired.shouldNotBe(visible);
        this.subEmptyField.shouldBe(visible);
        this.subInvalidDate.shouldNotBe(visible);
    }

    public void isVisibleSubInvalidDate() {
        this.subInvalidFormat.shouldNotBe(visible);
        this.subCardExpired.shouldNotBe(visible);
        this.subEmptyField.shouldNotBe(visible);
        this.subInvalidDate.shouldBe(visible);
    }

    public void waitNotification() {
        this.notification.shouldBe(visible, Duration.ofSeconds(100));;
    }

    public void isVisibleSuccessMessage() {
        this.successMessage.shouldBe(visible, Duration.ofSeconds(100));
    }

    public void isHiddenSuccessMessage() {
        this.successMessage.shouldBe(hidden);
    }

    public void isVisibleErrorMessage() {
        this.errorMessage.shouldBe(visible);
    }

    public void isHiddenErrorMessage() {
        this.errorMessage.shouldBe(hidden);
    }

    public void clickNotificationSuccessCloser() {
        this.notificationSuccessCloser.click();
    }

    public void clickNotificationErrorCloser() {
        this.notificationErrorCloser.click();
    }
}