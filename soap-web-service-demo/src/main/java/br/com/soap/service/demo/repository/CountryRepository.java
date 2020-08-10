package br.com.soap.service.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.baeldung.springsoap.gen.Country;
import com.baeldung.springsoap.gen.Currency;

@Component
public class CountryRepository {

	private Map<String, Country> countries = new HashMap<>();

	@PostConstruct
	public void initData() {
		countries.put("Ucrânia", buildCountry("Ucrânia", 41, "Kiev", Currency.EUR));
		countries.put("França", buildCountry("França", 2, "Paris", Currency.GBP));
		countries.put("Brasil", buildCountry("Brasil", 209, "Kiev", Currency.PLN));
	}

	public Country findCountry(String name) {
		return countries.get(name);
	}

	public List<Country> findAll() {
		return new ArrayList<>(countries.values());
	}

	public void save(Country country) {
		this.countries.put(country.getName(), country);
	}

	public void remove(String name) {
		this.countries.remove(name);
	}

	private Country buildCountry(String name, int population, String capital, Currency currency) {
		Country country = new Country();
		country.setName(name);
		country.setPopulation(population);
		country.setCapital(capital);
		country.setCurrency(currency);

		return country;
	}

	public Map<String, Country> getCountries() {
		return countries;
	}
	
	
}
