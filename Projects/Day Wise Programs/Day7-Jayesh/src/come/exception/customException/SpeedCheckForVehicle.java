package come.exception.customException;

public class SpeedCheckForVehicle extends Exception {	//if we want custom exception .. we extend Exception
	
	public SpeedCheckForVehicle(String getMessage)		//we take a string in constr. to throw the message pn exception 
	{
		super(getMessage);								//we pass string to Exception class paramet.. constr.. to print the message we want to print
	}
	
}
