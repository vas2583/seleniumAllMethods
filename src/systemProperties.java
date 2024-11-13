import org.apache.commons.lang3.RandomStringUtils;

public class systemProperties {
	public static String randomString() {
		String generateString=RandomStringUtils.randomAlphabetic(5);
		
		return generateString;
	}

	public static void main(String[] args) {
		 String user=System.getProperty("user.name");
		 System.out.println(user);
		 
		 String uns=randomString();
		 System.out.println(uns);
		
		 
	}

}
