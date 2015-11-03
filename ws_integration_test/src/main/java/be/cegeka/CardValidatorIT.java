package be.cegeka;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class CardValidatorIT {

	private static Endpoint endPoint;
	private static Validator validator;

	@Test
	public void shouldCheckCreditCardValidity_WrongCard() throws MalformedURLException {
		// GIVEN
		Mockito.when(validator.validate(Mockito.any(CreditCard.class))).thenReturn(false);
		Validator cardValidator = createValidatorInstance();

		// WHEN
		CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");

		// THEN
		assertThat(cardValidator.validate(creditCard)).isFalse();

	}

	@Test
	public void shouldCheckCreditCardValidity_CorrectCard() throws MalformedURLException {
		// GIVEN
		Mockito.when(validator.validate(Mockito.any(CreditCard.class))).thenReturn(true);
		Validator cardValidator = createValidatorInstance();

		// WHEN
		CreditCard creditCard = new CreditCard("12341233", "10/10", 1234, "VISA");

		// THEN
		assertThat(cardValidator.validate(creditCard)).isTrue();

	}

	private Validator createValidatorInstance() throws MalformedURLException {
		// Data to access the web service
		URL wsdlDocumentLocation = new URL("http://localhost:8080/cardValidator?wsdl");
		String namespaceURI = "http://cegeka.be/";
		String servicePart = "CreditCardValidatorStubImplService";
		String portName = "CreditCardValidatorStubImplPort";
		QName serviceQN = new QName(namespaceURI, servicePart);
		QName portQN = new QName(namespaceURI, portName);

		// Creates a service instance
		Service service = Service.create(wsdlDocumentLocation, serviceQN);
		return service.getPort(portQN, Validator.class);
	}

	@BeforeClass
	public static void setUpWSStub() {
		validator = Mockito.mock(Validator.class);
		endPoint = Endpoint.publish("http://localhost:8080/cardValidator", new CreditCardValidatorStubImpl(validator));
	}

	@AfterClass
	public static void stopWSStub() {
		endPoint.stop();
	}

}