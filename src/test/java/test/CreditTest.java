package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.CardInfo;
import db.DBManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import page.AppPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreditTest {
    private AppPage appPage;
    private DBManager dbManager;

    @BeforeAll
    public void Setup() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        this.appPage = new AppPage();
        this.dbManager = new DBManager();
        this.dbManager.clearDB();
    }

    @AfterEach
    public void Clear() {
        this.appPage.startPayment();
        this.dbManager.clearDB();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    //---db status-------------------------------------------------------------

    @Test
    public void shouldDBStatusForApproved() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberApproved());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        String actual = this.dbManager.getCreditStatus();
        String expected = "APPROVED";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDBStatusForDeclined() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberDeclined());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        String actual = this.dbManager.getCreditStatus();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDBStatusForStranger() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberStranger());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        String actual = this.dbManager.getCreditStatus();
        String expected = null;
        assertEquals(expected, actual);
    }

    //---db order-------------------------------------------------------------

    @Test
    public void shouldDBOrderForApproved() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberApproved());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        long actual =  this.dbManager.checkCreditOrder();
        long expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDBOrderForDeclined() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberDeclined());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        long actual =  this.dbManager.checkCreditOrder();
        long expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDBOrderForStranger() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberStranger());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        long actual = this.dbManager.checkCreditOrder();
        long expected = 0;
        assertEquals(expected, actual);
    }

    //---field number-------------------------------------------------------------

    @Test
    public void shouldNumberApproved() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberApproved());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();
        this.appPage.isVisibleSuccessMessage();
        this.appPage.clickNotificationSuccessCloser();
        this.appPage.isHiddenErrorMessage();
    }

    @Test
    public void shouldNumberDeclined() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberDeclined());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();
        this.appPage.isVisibleErrorMessage();
        this.appPage.clickNotificationErrorCloser();
        this.appPage.isHiddenSuccessMessage();
    }

    @Test
    public void shouldNumberStranger() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberStranger());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();
        this.appPage.isVisibleErrorMessage();
        this.appPage.clickNotificationErrorCloser();
        this.appPage.isHiddenSuccessMessage();
    }

    @Test
    public void shouldNumberInvalid() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberInvalid());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldNumberShort() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberShort());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldNumberEmpty() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getNumberEmpty());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubEmptyField();
    }

    //---field month-------------------------------------------------------------

    @Test
    public void shouldMonthInvalid() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getMonthInvalid());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldMonthDeficient() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getMonthDeficient());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidDate();
    }

    @Test
    public void shouldMonthExceed() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getMonthExceed());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidDate();
    }

    @Test
    public void shouldMonthShort() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getMonthShort());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldMonthEmpty() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getMonthEmpty());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubEmptyField();
    }

    //---field year--------------------------------------------------------------

    @Test
    public void shouldYearInvalid() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getYearInvalid());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldYearDeficient() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getYearDeficient());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubCardExpired();
    }

    @Test
    public void shouldYearExceed() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getYearExceed());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidDate();
    }

    @Test
    public void shouldYearShort() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getYearShort());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldYearEmpty() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getYearEmpty());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubEmptyField();
    }

    //---field owner-------------------------------------------------------------

    @Test
    public void shouldOwnerInvalid() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getOwnerInvalid());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldOwnerDeficient() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getOwnerDeficient());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldOwnerExceed() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getOwnerExceed());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldOwnerEmpty() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getOwnerEmpty());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubEmptyField();
    }

    //---field cvv---------------------------------------------------------------

    @Test
    public void shouldCvvInvalid() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getCvvInvalid());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldCvvDeficient() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getCvvDeficient());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldCvvEmpty() {
        this.appPage.startCredit();
        this.appPage.setFields(CardInfo.getCvvEmpty());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubEmptyField();
    }
}
