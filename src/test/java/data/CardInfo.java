package data;

import lombok.Value;

@Value
public class CardInfo {
    private String number;
    private String month;
    private String year;
    private String owner;
    private String cvv;

    //---number------------------------------------------------

    public static CardInfo getNumberApproved() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "23",
                "Smith John",
                "123");
    }

    public static CardInfo getNumberDeclined() {
        return new CardInfo(
                "4444 4444 4444 4442",
                "10",
                "23",
                "Smith John",
                "123");
    }

    public static CardInfo getNumberStranger() {
        return new CardInfo(
                "4444 4444 4444 4440",
                "10",
                "23",
                "Smith John",
                "123");
    }

    public static CardInfo getNumberInvalid() {
        return new CardInfo(
                "asdf +/*- 5555 )(&d",
                "10",
                "23",
                "Smith John",
                "123");
    }

    public static CardInfo getNumberShort() {
        return new CardInfo(
                "4444 4444",
                "10",
                "23",
                "Smith John",
                "123");
    }

    public static CardInfo getNumberEmpty() {
        return new CardInfo(
                "",
                "10",
                "23",
                "Smith John",
                "123");
    }

    //---month------------------------------------------------

    public static CardInfo getMonthInvalid() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "a1",
                "23",
                "Smith John",
                "123");
    }

    public static CardInfo getMonthDeficient() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "00",
                "23",
                "Smith John",
                "123");
    }

    public static CardInfo getMonthExceed() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "36",
                "23",
                "Smith John",
                "123");
    }

    public static CardInfo getMonthShort() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "2",
                "23",
                "Smith John",
                "123");
    }

    public static CardInfo getMonthEmpty() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "",
                "23",
                "Smith John",
                "123");
    }

    //---year------------------------------------------------

    public static CardInfo getYearInvalid() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "7f",
                "Smith John",
                "123");
    }

    public static CardInfo getYearDeficient() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "10",
                "Smith John",
                "123");
    }

    public static CardInfo getYearExceed() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "30",
                "Smith John",
                "123");
    }

    public static CardInfo getYearShort() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "3",
                "Smith John",
                "123");
    }

    public static CardInfo getYearEmpty() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "",
                "Smith John",
                "123");
    }

    //---owner------------------------------------------------

    public static CardInfo getOwnerInvalid() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "23",
                "56-k!@:..%",
                "123");
    }

    public static CardInfo getOwnerDeficient() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "23",
                "A",
                "123");
    }

    public static CardInfo getOwnerExceed() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "23",
                "Abdallah ibn Aziz ibn Fatikh ibn Ayahallic ibn Farukh ibn Mohammad ibn Abdallah ibn Aziz ibn Fatikh ibn Ayahallic ibn Farukh ibn Mohammad ibn Abdallah ibn Aziz ibn Fatikh ibn Ayahallic ibn Farukh ibn Mohammad ibn Abdallah ibn Aziz ibn Fatikh ibn Ayahallic ibn Farukh ibn Mohammad",
                "123");
    }

    public static CardInfo getOwnerEmpty() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "23",
                "",
                "123");
    }

    //---cvv------------------------------------------------

    public static CardInfo getCvvInvalid() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "23",
                "Smith John",
                "4g!");
    }

    public static CardInfo getCvvDeficient() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "23",
                "Smith John",
                "45");
    }

    public static CardInfo getCvvEmpty() {
        return new CardInfo(
                "4444 4444 4444 4441",
                "10",
                "23",
                "Smith John",
                "");
    }

}