import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 // ���� ��¥ ���ϱ�
		 LocalDate now = LocalDate.now();         
		 // ���� ����        
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 // ���� ����       
		 String formatedNow = now.format(formatter);         
		 // ��� ���       
		 System.out.println(formatedNow);  
	}
}

//
//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
