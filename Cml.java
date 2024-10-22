import java.util.*;

public class Cml{

	public static int convert(String a){
			return a.charAt(0) - '0';
	} 

	public static void main(String[] args){
		int sum = 0;
		for (int i = 0; i < args.length; i++)
			sum += convert(args[i]);
		System.out.println(sum);


		// int val2 = convert(args[1]);
		// int val1 = Integer.parseInt(args[0]);
		// int val2 = Integer.parseInt(args[1]);
		// int val2 = (int)args[1] - (int)"0";
		// System.out.println((args[0].charAt(0) - '0');
	}
}