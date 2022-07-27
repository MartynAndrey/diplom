package data;

public class CardInfo {
    private String number;
    private String month;
    private String year;
    private String owner;
    private String cvv;

    //---number------------------------------------------------

    public static String getNumberApproved() {
        return "4444 4444 4444 4441";
    }

    public static String getNumberDeclined() {
        return "4444 4444 4444 4442";
    }

    public static String getNumberStranger() {
        return "4444 4444 4444 4440";
    }

    public static String getNumberInvalid() {
        return "4444 asdf +/*-";
    }

    public static String getNumberEmpty() {
        return "";
    }

    //---month------------------------------------------------

    public static String getMonthValid() {
        return "09";
    }

    public static String getMonthInvalid() {
        return "asdf";
    }

    public static String getMonthDeficient() {
        return "00";
    }

    public static String getMonthExceed() {
        return "36";
    }

    public static String getMonthEmpty() {
        return "";
    }

    //---year------------------------------------------------

    public static String getYearValid() {
        return "23";
    }

    public static String getYearInvalid() {
        return "asdf";
    }

    public static String getYearDeficient() {
        return "10";
    }

    public static String getYearExceed() {
        return "30";
    }

    public static String getYearEmpty() {
        return "";
    }

    //---owner------------------------------------------------

    public static String getOwnerValid() {
        return "Smith John";
    }

    public static String getOwnerInvalid() {
        return "F56a-s!@d:..fT%";
    }

    public static String getOwnerDeficient() {
        return "A";
    }

    public static String getOwnerExceed() {
        return "Abdallah ibn Aziz ibn Fatikh ibn Ayahallic ibn Farukh ibn Mohammad ibn Abdallah ibn Aziz ibn Fatikh ibn Ayahallic ibn Farukh ibn Mohammad ibn Abdallah ibn Aziz ibn Fatikh ibn Ayahallic ibn Farukh ibn Mohammad ibn Abdallah ibn Aziz ibn Fatikh ibn Ayahallic ibn Farukh ibn Mohammad";
    }

    public static String getOwnerEmpty() {
        return "";
    }

    //---cvv------------------------------------------------

    public static String getCvvValid() {
        return "123";
    }

    public static String getCvvInvalid() {
        return "gh6bs";
    }

    public static String getCvvDeficient() {
        return "45";
    }

    public static String getCvvExceed() {
        return "6589";
    }

    public static String getCvvEmpty() {
        return "";
    }
}
