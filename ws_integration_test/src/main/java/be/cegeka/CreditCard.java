package be.cegeka;


import java.nio.CharBuffer;

/**
 * Created by rdehuyss on 03.11.15.
 */
public class CreditCard {
    private String number;
    private String expiryDate;
    private int anotherNumber;
    private String type;

    public CreditCard() {
        //Needed for WS
    }


    public CreditCard(String number, String expiryDate, int anotherNumber, String type) {

        this.number = number;
        this.expiryDate = expiryDate;
        this.anotherNumber = anotherNumber;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getAnotherNumber() {
        return anotherNumber;
    }

    public void setAnotherNumber(int anotherNumber) {
        this.anotherNumber = anotherNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
