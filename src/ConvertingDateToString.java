import java.text.SimpleDateFormat;

public class ConvertingDateToString {

	public static void main(String[] args) throws Exception {
		String date="18-11-2024";
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date ud1=sdf.parse(date);
		System.out.println(ud1);
		String date1=sdf.format(ud1);
		System.out.println(date1);
		

	}

}
