# springMVC

Simple spring mvc rest application

Instruction to execute an app:
- Download source.
- Run command `mvn clean install`.
- Execute `mvn tomcat7:run` - it will run app on default port (8080) 
- If you wat to specify port, run following command: `mvn tomcat7:run -Dmaven.tomcat.port=portNumber`

Also, it's possible to execute app via jetty:

Instead of 3-4 steps  above run command below

`mvn jetty:run -Djetty.port=portNumber`

#### Available URLs:

GET `*/springmvc/users` - get all available users

GET `*/springmvc/users/{userId}` - get user with specific ID

DELETE `*/springmvc/users/` - delete all users

DELETE `*/springmvc/users/{userId}` - delete specific users with ID

PUT `*/springmvc/users/{userId}` - update user by ID

POST `*/springmvc/users/` - create user 

Example of request body
`
{
 "username": "nazar",
 "email", "email@gmail.com",
 "password", "123qwe"
}
`
