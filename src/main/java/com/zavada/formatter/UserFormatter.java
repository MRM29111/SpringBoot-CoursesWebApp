package com.zavada.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.zavada.entity.User;

@Component
public class UserFormatter implements Formatter<User> {

	@Override
	public User parse(String text, Locale locale) throws ParseException {
		User user = new User();
		user.setId(Integer.valueOf(text));
		return user;
	}

	@Override
	public String print(User object, Locale locale) {
		return String.valueOf(object.getId());
	}

}
