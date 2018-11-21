import java.util.Scanner;

public class BinaryConverter {

	public static void main(String[] args) {
		
		String a = readBinary();
		int dec = toDecimal(a);
		
		System.out.println("Binary: " + a);
		System.out.println("Decimal: " + dec);
		

	}
	
	public static String readBinary()
	{
		Scanner input = new Scanner(System.in);
		StringBuilder stringBuilder = new StringBuilder();
		
		
		boolean i = true;
		while(i)
		{
			System.out.println("Please enter 1 or 0. If you are done, press c");
			String str = input.next();
			if(!checkValidity(str))
			{
				System.out.println("Error! Input must be 1s and 0s  OR c only");
			}
			else if(str.contains("1") || str.contains("0"))
				{
					stringBuilder.append(str);
				} 
				else if(str.contains("c"))
				{
					i = false;
				}
				
		}
		input.close();
		return stringBuilder.toString();
	}
	public static int toDecimal(String binary) 
	/*
	* If the last digit is 1, it calculates 2 to the power of its index 
	* and adds it to the sum.
	*/
	
	{
		int pos=0;
		int decimal=0;
		
		while(binary.length() > 0)
		{
			String s = binary.substring((binary.length()-1));
			if(s.equals("1"))
			{
				decimal += Math.pow(2, pos);
				binary = binary.substring(0, (binary.length()-1));
				pos++;
			} else
			{
				binary = binary.substring(0, (binary.length()-1));
				pos++;
			}
		}
		return decimal;
		
	}
	public static boolean checkValidity(String str)
	/* Checking whether the string only contains 1 or 0 or c.
	 * If it contains both c and 0 or 1, it returns false.
	 */
	{
		boolean bool = true;
		if(str.contains("c") && (str.contains("1") || str.contains("0"))) return false;
		while(str.length() > 0 && bool)
		{
			String s = str.substring((str.length()-1));
			if (!s.contains("1") && !s.contains("0") && !s.contains("c")) return false;
			str = str.substring(0, (str.length()-1));	
		}
		return true;
	}

}
