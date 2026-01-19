### **Security Diagram**
- Every request passes through a series of filters (**Filter Chain**), till it reaches the controller.
	- Each filter has its own configuration and acts by itself.
	- There are both only configuration methods and security features from spring in the filter chain.
- One of the security features is "**AuthenticationFilter**", acts intercepting the requests for login and validates. (SQL Injection and scripts protection).
	- It creates an *Authentication Object* to package the credentials.
	- Hands the Object to *AuthenticationManager*.
	- Receive the answer from *AuthenticationManager* and creates a SECURITY CONTEXT.
		-  stores the information of the authentication.
- **AuthenticationManager**: Decides what to do with the object (credentials).
	- For it when it decides to authenticate, he calls the *Authentication Provider* and it decides to give the user access by his *UserDetails* object.
	- Returns to *Authentication Filter*.
- **AuthenticationProvider**: 
	- Is responsible to check in if the credentials are correct or not, and for to validate the credentials it need two other itens:
		- **PasswordEncoder**: Responsible to prepare (encode) the password so the *AuthenticationProvider* be able to encrypt/decrypt after.
		- **UserDetailsService**: Responsible to load the user details and all of his rules.
			-  Need to access the database to load the user by username || email || ...
			- Creates a UserObjet to return to the *AuthenticationProvider*.

![[SpringSecurityDiagram.png]]

---