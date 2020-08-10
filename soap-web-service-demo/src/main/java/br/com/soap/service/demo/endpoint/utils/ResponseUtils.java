package br.com.soap.service.demo.endpoint.utils;

import java.util.List;

import com.baeldung.springsoap.gen.Country;
import com.baeldung.springsoap.gen.GetCountryResponse;
import com.baeldung.springsoap.gen.ListCountryResponse;

public class ResponseUtils {

	private ResponseUtils() {
	}

	public static GetCountryResponse buildGetCountryResponse(Country country) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(country);

		return response;
	}

	public static ListCountryResponse buildListCountrResponse(List<Country> countries) {
		ListCountryResponse response = new ListCountryResponse();
		response.getCountry().addAll(countries);

		return response;
	}

}
