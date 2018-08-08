package hello;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.Or;
import io.spring.guides.gs_producing_web_service.Order;
import io.spring.guides.gs_producing_web_service.Status;
import io.spring.guides.gs_producing_web_service.Warehouse;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
	private static final Map<String, Status> statusOrder = new HashMap<>();

	@PostConstruct
	public void initData() {

		
		Status warehouse1 = new Status();
		warehouse1.setId("Monitor");
		warehouse1.setPrice(250);
		warehouse1.setCode(1);
		warehouse1.setWarehouse(Warehouse.A);

		statusOrder.put(warehouse1.getId() + warehouse1.getPrice(), warehouse1);

		Status warehouse2 = new Status();
		warehouse2.setId("Videocard");
		warehouse2.setPrice(500);
		warehouse2.setCode(1);
		warehouse2.setWarehouse(Warehouse.B);

		statusOrder.put(warehouse2.getId() + warehouse2.getPrice(), warehouse2);
		
		//Country spain = new Country();
		//spain.setName("Spain");
		//spain.setCapital("Madrid");
		//spain.setCurrency(Currency.EUR);
		//spain.setPopulation(46704314);

		//countries.put(spain.getName(), spain);

	}

	public Status getStatus(String name){
		return statusOrder.get(name);
	}

//	public /*Status*/ OrderType findWarehouse(String name) {
//		Assert.notNull(name, "The order's name must not be null.");
//		return statusOrder.get(name);
//	}

}