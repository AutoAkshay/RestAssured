package api.endpoints;
 
/*

Swagger URI ---> https://petstore.swagger.io/

Create User	(Post)   :	https://petstore.swagger.io/v2/user
Get User	(Get)    :	https://petstore.swagger.io/v2/user/{username}
Update User	(Put)    :	https://petstore.swagger.io/v2/user/{username}
Delete User	(Delete) :	https://petstore.swagger.io/v2/user/{username}

 */
public class Routes {
	
	public static String baser_url= "https://petstore.swagger.io/v2/user/";
	
	//User module
	
	public static String post_url=baser_url;
	public static String get_url=baser_url+"{username}";
	public static String update_url=baser_url+"{username}";
	public static String delete_url=baser_url+"{username}";
}
