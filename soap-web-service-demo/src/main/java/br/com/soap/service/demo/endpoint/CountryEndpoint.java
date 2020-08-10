package br.com.soap.service.demo.endpoint;

import static br.com.soap.service.demo.endpoint.utils.ResponseUtils.buildGetCountryResponse;
import static br.com.soap.service.demo.endpoint.utils.ResponseUtils.buildListCountrResponse;

import java.util.List;

import javax.jws.Oneway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.baeldung.springsoap.gen.Country;
import com.baeldung.springsoap.gen.CreateCountryRequest;
import com.baeldung.springsoap.gen.GetCountryRequest;
import com.baeldung.springsoap.gen.GetCountryResponse;
import com.baeldung.springsoap.gen.ListCountryResponse;
import com.baeldung.springsoap.gen.RemoveCountryRequest;

import br.com.soap.service.demo.service.CountryService;

@Endpoint
public class CountryEndpoint {

	public static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

	private CountryService countryService;

	@Autowired
	public CountryEndpoint(CountryService countryService) {
		this.countryService = countryService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		Country country = countryService.findByName(request.getName());
		return buildGetCountryResponse(country);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listCountryRequest")
	@ResponsePayload
	public ListCountryResponse list() {
		List<Country> countries = countryService.list();
		return buildListCountrResponse(countries);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCountryRequest")
	@Oneway
	public void save(@RequestPayload CreateCountryRequest request) {
		Country country = request.getCountry();
		countryService.save(country);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeCountryRequest")
	@Oneway
	public void remove(@RequestPayload RemoveCountryRequest request) {
		countryService.remove(request.getName());
	}

}
