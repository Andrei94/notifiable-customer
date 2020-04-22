package notifiable.customer;

import io.micronaut.function.executor.FunctionInitializer;
import io.micronaut.function.FunctionBean;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

import java.io.IOException;
import java.util.function.Function;

@FunctionBean("notifiable-customer")
public class NotifiableCustomerFunction extends FunctionInitializer implements Function<NotifiableCustomer, Boolean> {
	@Override
	public Boolean apply(NotifiableCustomer msg) {
		SesClient build = SesClient.builder().region(Region.EU_CENTRAL_1).build();
		build.sendEmail(SendEmailRequest.builder()
				.destination(Destination.builder().toAddresses("andreiprecup69@gmail.com").build())
				.replyToAddresses(msg.getEmail())
				.source("andreiprecup69@gmail.com")
				.message(Message.builder()
						.subject(Content.builder().data("New notifiable customer: " + msg.getEmail()).charset("UTF-8").build())
						.body(Body.builder().text(Content.builder().data("").build()).build())
						.build())
				.build()
		);
		return true;
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

