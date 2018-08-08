package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetWarehouseRequest;
import io.spring.guides.gs_producing_web_service.GetWarehouseResponse;
import io.spring.guides.gs_producing_web_service.Order;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private CountryRepository warehouseRepository;

	@Autowired
	public CountryEndpoint(CountryRepository warehouseRepository) {
		this.warehouseRepository = warehouseRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWarehouseRequest")
	@ResponsePayload
	public GetWarehouseResponse getWarehouse(@RequestPayload GetWarehouseRequest request) {
		GetWarehouseResponse response = new GetWarehouseResponse();
		response.setStatus(warehouseRepository.getStatus(request.getId() + request.getPrice()));
		//response.setStatus(warehouseRepository.getStatus(request.getOrder())





		return response;
	}


//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
//	@ResponsePayload
//	public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
//		GetStudentResponse response = new GetStudentResponse();
//		response.setStudent(studentUtility.getStudent(request.getStudentId()));
//		return response;
//	}
}