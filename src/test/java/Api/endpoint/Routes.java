package Api.endpoint;

public class Routes {
/* create User >>> https://petstore.swagger.io/v2/user
   Get User   >>>> https://petstore.swagger.io/v2//user/{username}
   Update User >>> https://petstore.swagger.io/v2//user/{username}
   Delet User >>>  https://petstore.swagger.io/v2/user/{username}
*/
public static String Base_Url	="https://petstore.swagger.io/v2";

// user module urls
public static String Post_Url = Base_Url+"/user";
public static String Get_Url = Base_Url+"/user/{username}";
public static String Put_Url = Base_Url+"/user/{username}";
public static String Delet_Url = Base_Url+"/user/{username}";

// pet Module urls

// store module urls
}
