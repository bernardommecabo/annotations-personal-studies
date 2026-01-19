### **In a real project situation**
- At first build its created temporarily a **Default Filter Chain** with two endpoints reserved for the login and logout services, this is automated and de default login is:
	- user - *password is given through console*
	- Default authentication made with a form.
	- Creation of two forms, login and logout .
	- User and password can be changed in the application.properties by the following lines:
		- spring.security.user.name = your username
		- spring.security.user.password = your password 
- *Observations:*
	- The logic of the **Default Filter Chain** is kept on *SpringBootWebSecurityConfiguration.class*
##### Form Based VS Basic Authentication
- There are two types of default authentications disposed by Spring Security, being them : 
	- Form based authentication (ui with http/css for login endpoint)
	- Basic authentication (for postman or others non ui API platform)
- *Both tipes of authentication use by default JSession to manage the session using cookies*
#### **Configuring Spring Security**
- To customize the **Filter Chain**, it's necessary to create a *SecurityConfig* class and create a *SecurityFilterChain* **@Bean**.
	- The *SecurityConfig* must be a configuration class (**@Configuration**) and have the *WebSecurity* enabled (**@EnableWebSecurity**).

- It's really important to change the session management to **STATELESS**, this guarantee the client request to the server is completely self-contained and independent.
	- With the following code addition:
	```
		// inside SecurityFilterChain class
		  http.sessionManagement((session) ->
			  session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	``` 

- *SecurityConfig* example:
- ```  
	@Bean  
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws 
	Exception 
	{ 
	    http.authorizeHttpRequests((requests) ->
			requests.anyRequest().authenticated());  
	    http.sessionManagement((session) -> 
		    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));  
	    //http.formLogin(withDefaults());  
	    http.httpBasic(withDefaults());  
	    return http.build();  
	}
  ```
  
![[AuthorizationRequest.png]]

---

### ***Spring Boot Anotations mentioned***
- ***@Bean***:  Is a **method-level** annotation, used within a ***@Configuration*** class to declare that the object returned by that method should be registered as a bean.
- ***@Configuration***: Indicates the class is a source of bean definitions so Spring should be able to process, generate and manage them.
- ***@EnableWebSecurity:*** Tells Spring Boot to enable web security features in the application and gives the liberty to customize the security configuration.