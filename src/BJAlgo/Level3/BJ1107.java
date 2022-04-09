package BJAlgo.Level3;

import java.util.*;

public class BJ1107 {

	public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        
        int target = scan.nextInt();
        int m = scan.nextInt();
        
        boolean[] broken = new boolean[10];
        for(int i = 0; i < m; i++) {
            int n = scan.nextInt();
            broken[n] = true;
        }
        
        int result = Math.abs(target - 100); //�ʱⰪ ����
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            
            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) { //���峭 ��ư�� ������ �ϸ�
                    isBreak = true; 
                    break; //�� �̻� Ž������ �ʰ� �������´�.
                }
            }
            if(!isBreak) { //i�� ������ ���峭 ��ư�� ������ �ʴ´ٸ�
                int min = Math.abs(target - i) + len; //i�� ���� ��(len) target���� �̵��ϴ� Ƚ��(target - i)
                result = Math.min(min, result);
            }
        }        
        System.out.println(result);
    }

}
