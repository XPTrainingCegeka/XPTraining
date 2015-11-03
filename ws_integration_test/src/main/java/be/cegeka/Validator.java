package be.cegeka;

import javax.jws.WebService;

@WebService
public interface Validator {
    public boolean validate(CreditCard creditCard);
}

