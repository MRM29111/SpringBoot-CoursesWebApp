package com.zavada;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.zavada.entity.Country;
import com.zavada.entity.User;
import com.zavada.entity.enumeration.Role;
import com.zavada.repository.CountryRepository;
import com.zavada.repository.UserRepository;

@SpringBootApplication
public class SpringBootCoursesWebAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootCoursesWebAppApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootCoursesWebAppApplication.class, args);
		addAdmin(context);
		addCountries(context);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setForceEncoding(true);
		characterEncodingFilter.setEncoding("UTF-8");
		registrationBean.setFilter(characterEncodingFilter);
		return registrationBean;
	}

	static void addAdmin(ConfigurableApplicationContext context) {
		String adminEmail = "admin@gmail.com";
		String adminPassword = "123";
		String teacherEmail = "teacher@gmail.com";
		String teacherPassword = "123";
		String studentEmail = "student@gmail.com";
		String studentPassword = "123";

		UserRepository userRepository = context.getBean(UserRepository.class);
		User entity = userRepository.findForAuthentication(adminEmail); 
		if (entity == null) { // If first NULL -> another also NULL -- logic :D
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			entity = new User();
			entity.setEmail(adminEmail);
			entity.setPassword(encoder.encode(adminPassword));
			entity.setRole(Role.ROLE_ADMIN);
			userRepository.save(entity);
			
			entity = new User();
			entity.setEmail(teacherEmail);
			entity.setPassword(encoder.encode(teacherPassword));
			entity.setRole(Role.ROLE_TEACHER);
			userRepository.save(entity);
			
			entity = new User();
			entity.setEmail(studentEmail);
			entity.setPassword(encoder.encode(studentPassword));
			entity.setRole(Role.ROLE_STUDENT);
			userRepository.save(entity);
		}
	}

	static void addCountries(ConfigurableApplicationContext context) {
		CountryRepository countryRepository = context.getBean(CountryRepository.class);
		List<Country> countriesList = countryRepository.findAll();

		LinkedHashMap<String, String> countries = new LinkedHashMap<>();
		countries.put("Ukraine", "UA");
		countries.put("Turkey", "TR");
		countries.put("Thailand", "TH");
		countries.put("Spain", "ES");
		countries.put("Singapore", "SG");
		countries.put("Romania", "RO");
		countries.put("Poland", "PL");
		countries.put("Mexico", "MX");
		countries.put("Italy", "IT");
		countries.put("India", "IN");
		countries.put("Greece", "GR");
		countries.put("Germany", "DE");
		countries.put("France", "FR");
		countries.put("Finland", "FI");
		countries.put("Estonia", "EE");
		countries.put("Denmark", "DK");
		countries.put("Cyprus", "CY");
		countries.put("Brazil", "BR");

		if (countriesList.size() == 0) {
			for (Map.Entry<String, String> c : countries.entrySet()) {
				Country country = new Country();
				country.setName(c.getKey());
				country.setShortName(c.getValue());
				countryRepository.save(country);
			}

		}
	}
}
