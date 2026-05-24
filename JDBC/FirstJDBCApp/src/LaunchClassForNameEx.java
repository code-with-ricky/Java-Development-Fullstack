import java.sql.DriverManager;

public class LaunchClassForNameEx {

	public static void main(String[] args) throws ClassNotFoundException {
//		Demo d = new Demo(); // output of this --> prints both block static and non static
		
		// if want to load only the class then we can use Class.forName("class-name");
		Class.forName("Demo"); // since demo is in default package so written only "Demo" else proper path need to be added
	}

}

class Demo {
	// when class Demo is loaded that time this works
	static {
		System.out.println("Static Block");
	}
	
	// when object of the class is created that time this block runs
	{
		System.out.println("Instance Block ==> Non static");
	}
}