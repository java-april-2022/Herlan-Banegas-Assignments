package com.herlan.bookClub.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.herlan.bookClub.models.User;
import com.herlan.bookClub.repositories.UserRepository;
@Component
public class UserValidator implements Validator{
	
	@Autowired
	private UserRepository uRepo;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		User user = (User) target;
		if(!user.getConfirm().equals(user.getPassword())) {
			errors.rejectValue("confirm", "Match","Password Does Not Match");
		}
		if(uRepo.findByEmail(user.getEmail())!=null) {
			errors.rejectValue("email", "unique","Email Address already in use");
		}
	}
	

}

