import java.util.Scanner;

public class Lab1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int qtosNumeros = 5;
		int num;
		
		int maior =  Integer.MIN_VALUE;
		int menor = Integer.MAX_VALUE;
		
		for (int i = 0; i < qtosNumeros; i++) {
			System.out.print( "Digite o numero: ");
			num = sc.nextInt();
			System.out.println(num);
		}
	}
}