package com.ecomerce.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email format is invalid")
    private String email;

    public UserRequest(
			@NotBlank(message = "Name must not be blank") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String name,
			@NotBlank(message = "Email must not be blank") @Email(message = "Email format is invalid") String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
