package br.com.soap.service.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baeldung.springsoap.gen.Country;

import br.com.soap.service.demo.exceptions.ConflictException;
import br.com.soap.service.demo.exceptions.NotFoundException;
import br.com.soap.service.demo.exceptions.utils.ServiceFaultUtils;
import br.com.soap.service.demo.repository.CountryRepository;

@Service
public class CountryService {

	private static final Logger log = LoggerFactory.getLogger(CountryService.class);

	@Autowired
	private CountryRepository repository;

	public void save(Country country) {
		log.info("Saving country '{}'", country.getName());

		if (this.exists(country.getName())) {
			log.error("Country named '{}'  is already registered.", country.getName());
			throw new ConflictException(ServiceFaultUtils
					.buildConflictResponse("Country named '" + country.getName() + "' is alredy registered"));
		}

		repository.save(country);
		log.info("Country '{}' saved sucessfully!", country.getName());
	}

	public List<Country> list() {
		log.info("Listing all countries...");
		return repository.findAll();
	}

	public Country findByName(String name) {
		log.info("Searching by name '{}'", name);
		if (!this.exists(name)) {
			this.logNotFound(name);
			throw new NotFoundException(ServiceFaultUtils.buildNotFoundResponse(this.getNotFoundMessage(name)));
		}

		return repository.findCountry(name);
	}

	public void remove(String name) {
		log.info("Removing country '{}'", name);

		if (!this.exists(name)) {
			this.logNotFound(name);
			throw new NotFoundException(ServiceFaultUtils.buildNotFoundResponse(this.getNotFoundMessage(name)));
		}

		repository.remove(name);
	}

	private boolean exists(String name) {
		return repository.getCountries().containsKey(name);
	}

	private String getNotFoundMessage(String name) {
		return "Country named '" + name + "' Not Found";
	}

	private void logNotFound(String name) {
		log.error("Country named '{}' Not Found", name);
	}

}
