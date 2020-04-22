package notifiable.customer;

import io.micronaut.core.annotation.*;

@Introspected
public class NotifiableCustomer {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

