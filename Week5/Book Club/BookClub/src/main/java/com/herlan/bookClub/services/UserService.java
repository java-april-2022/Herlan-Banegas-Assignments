package com.herlan.bookClub.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herlan.bookClub.models.User;
//import com.authentication.models.LoginUser;
import com.herlan.bookClub.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User user) {
        // TO-DO: Additional validations!
    	String hashedPass=BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    	user.setPassword(hashedPass);
        return userRepo.save(user);
    }
    
    //find user by Email
    
    public User findByEmail(String email) {
    	return userRepo.findByEmail(email);
    }
    
    public User findById(Long id) {
    	return userRepo.findById(id).orElse(null);
    }
    
    //authenticate User
    public boolean authenticateUser(String email, String password) {
    	//first find user by email
    	User user = userRepo.findByEmail(email);
    	//if we can't find by email, return false
    	if (user == null) {
    		return false;
    	}else {
    		//if passwords match, return true, else return false
    		if(BCrypt.checkpw(password, user.getPassword())) {
    			return true;
    		}else {
    			return false;
    		}
    	}
    }
//    public User login(LoginUser newLoginObject, BindingResult result) {
//        // TO-DO: Additional validations!
//        return null;
//    }

}
