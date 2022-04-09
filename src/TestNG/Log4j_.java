package TestNG;
import org.apache.logging.log4j.*;

public class Log4j_ 
{
	private static Logger Log = LogManager.getLogger(Log4j_.class.getName());
	
	public static void main(String[] args) 
	{
			Log.debug("I am Debugging");
			Log.info("Object is present");
			Log.error("Object is not present");
			Log.fatal("This is fatal");
	}

}
