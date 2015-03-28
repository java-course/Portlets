package com.geminisystems.portlet.validator;

import com.geminisystems.portlet.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * Author: Georgy Gobozov
 * Date: 13.05.13
 */
public class UserValidator implements Validator {


    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "User name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "User email is required");

        if (!isValidEmail(user.getEmail()) && errors.getErrorCount() < 1) {
            errors.rejectValue("email", "", "Invalid email address");
            return;
        }


    }

    private boolean isValidEmail(String email) {
        String email_pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-.]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(email_pattern);
        return pattern.matcher(email).matches();
    }

}
