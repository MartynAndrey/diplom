package test;

import data.CardInfo;
import db.DBManager;
import org.junit.jupiter.api.*;
import page.AppPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PaymentTest {
    private AppPage appPage;
    private DBManager dbManager;

    @BeforeAll
    public void Setup() {
        this.appPage = new AppPage();
        this.dbManager = new DBManager();
        this.dbManager.clearDB();
    }

    @AfterEach
    public void Clear() {
        this.appPage.startCredit();
        this.dbManager.clearDB();
    }

    //---db status-------------------------------------------------------------

    @Test
    public void shouldDBStatusForApprovedValid() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberApproved());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        String actual = this.dbManager.getPaymentStatus();
        String expected = "APPROVED";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDBStatusForDeclinedValid() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberDeclined());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        String actual = this.dbManager.getPaymentStatus();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDBStatusForStrangerValid() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberStranger());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        String actual = this.dbManager.getPaymentStatus();
        String expected = null;
        assertEquals(expected, actual);
    }

    //---db order-------------------------------------------------------------

    @Test
    public void shouldDBOrderForApprovedValid() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberApproved());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        long actual =  this.dbManager.checkPaymentOrder();
        long expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDBOrderForDeclinedValid() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberDeclined());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        long actual =  this.dbManager.checkPaymentOrder();
        long expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDBOrderForStrangerValid() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberStranger());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.waitNotification();

        long actual = this.dbManager.checkPaymentOrder();
        long expected = 0;
        assertEquals(expected, actual);
    }

    //---field number-------------------------------------------------------------

    @Test
    public void shouldNumberApproved() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberApproved());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSuccessMessage();
        this.appPage.isHideErrorMessage();
    }

    @Test
    public void shouldNumberDeclined() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberDeclined());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleErrorMessage();
        this.appPage.isHideSuccessMessage();
    }

    @Test
    public void shouldNumberStranger() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberStranger());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleErrorMessage();
        this.appPage.isHideSuccessMessage();
    }

    @Test
    public void shouldNumberInvalid() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberInvalid());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubInvalidFormat();
    }

    @Test
    public void shouldNumberEmpty() {
        this.appPage.startPayment();
        this.appPage.setCardNumber(CardInfo.getNumberEmpty());
        this.appPage.setCardMonth(CardInfo.getMonthValid());
        this.appPage.setCardYear(CardInfo.getYearValid());
        this.appPage.setCardOwner(CardInfo.getOwnerValid());
        this.appPage.setCardCVV(CardInfo.getCvvValid());
        this.appPage.clickContinueButton();
        this.appPage.isVisibleSubEmptyField();
    }

    //---field month-------------------------------------------------------------

    //---field year--------------------------------------------------------------

    //---field owner-------------------------------------------------------------

    //---field cvv  -------------------------------------------------------------

}
