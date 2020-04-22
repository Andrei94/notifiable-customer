package notifiable.customer;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class NotifiableCustomerFunctionTest {
	@Inject
	NotifiableCustomerClient client;

	@Test
	public void testFunction() {
		NotifiableCustomer body = new NotifiableCustomer();
		body.setEmail("notifiable-customer");
		assertEquals("notifiable-customer", client.apply(body).blockingGet().getEmail());
	}
}
