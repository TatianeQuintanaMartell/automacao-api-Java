package Utils;


public class EndPoints {
     protected static final String BASE_URI = FileOperations.getProperties("EnvironmentProperties").getProperty("baseUri");
    //protected static final String BASE_URI= ObjectUtils.getPropertiesData("EnvironmentProperties", "baseUri");
    protected static final String PATH_TASK= FileOperations.getProperties("EnvironmentProperties").getProperty("tasks");
    protected static final String PATH_USERS= FileOperations.getProperties("EnvironmentProperties").getProperty("users");
    protected static final String PATH_SESSION= FileOperations.getProperties("EnvironmentProperties").getProperty("sessions");
    protected static final String PASSWORD= FileOperations.getProperties("UserDataProperties").getProperty("password");
    protected static  String email ;


}
