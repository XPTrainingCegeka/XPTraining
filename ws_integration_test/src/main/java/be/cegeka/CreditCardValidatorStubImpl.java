package be.cegeka;

import javax.jws.WebService;

@WebService(endpointInterface = "be.cegeka.CreditCardValidatorStubImpl")
public class CreditCardValidatorStubImpl implements Validator {

	private Validator validator;

	public CreditCardValidatorStubImpl(Validator validator) {
		this.validator = validator;
	}

	public boolean validate(CreditCard creditCard) {
		return validator.validate(creditCard);
	}
}