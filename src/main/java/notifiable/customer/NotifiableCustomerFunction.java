package notifiable.customer;

import io.micronaut.function.executor.FunctionInitializer;
import io.micronaut.function.FunctionBean;

import javax.inject.*;
import java.io.IOException;
import java.util.function.Function;

@FunctionBean("notifiable-customer")
public class NotifiableCustomerFunction extends FunctionInitializer implements Function<NotifiableCustomer, NotifiableCustomer> {
	@Override
	public NotifiableCustomer apply(NotifiableCustomer msg) {
		return msg;
	}

	/**
	 * This main method allows running the function as a CLI application using: echo '{}' | java -jar function.jar
	 * where the argument to echo is the JSON to be parsed.
	 */
	public static void main(String... args) throws IOException {
		NotifiableCustomerFunction function = new NotifiableCustomerFunction();
		function.run(args, (context) -> function.apply(context.get(NotifiableCustomer.class)));
	}
}

