import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext contex = new ClassPathXmlApplicationContext("context.xml");
		CustomerRepository customerRep = contex.getBean("customerRepository", CustomerRepository.class);
		System.out.println(customerRep.getCustomerName(34L));
		customerRep.getCustomer(1L);
		
		Customer customer1 = new Customer("Janek");
		Customer customer2 = new Customer(null);
		try {
		customerRep.addCustomer(customer1);
		customerRep.addCustomer(customer2);
		}catch(Exception d) {}

	}
}
