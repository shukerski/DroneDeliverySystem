import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Super fast drone delivery system!");

		Scanner input = new Scanner(System.in);

		String req = input.nextLine();

		Request request = new Request(req);
	}

}
