package Services;

public class MainController {

	public static void main(String[] args) {
		System.out.println("Begin...");

		ServiceDesk desk = new ServiceDesk();
		desk.print();
		
		for(int i=0;i<3;i++)
			desk.add();
		
		desk.print();

		Handler h1 = new Handler();
		desk.handle(h1);
		desk.print();

		Handler h2 = new Handler();
		desk.add(); 
		desk.handle(h1);
		desk.handle(h2);
		
		desk.add(); 
		desk.add();
		desk.print();

		System.out.println(desk.tickets(Ticket.Status.CLOSED));
		System.out.println(desk.tickets(Ticket.Status.NEW));
		System.out.println(desk.tickets(Ticket.Status.INPROGRESS));
		System.out.println("---");
		
		System.out.println(desk.tickets(h1));
		System.out.println(desk.tickets(h2));
		System.out.println("---");
		
		System.out.println(desk.check(1));
		System.out.println(desk.check(2));
		System.out.println(desk.check(999));
		System.out.println("---");
		
		desk.close(h1);
		desk.print();
		
		System.out.println(desk.tickets(Ticket.Status.CLOSED));
		System.out.println(desk.tickets(Ticket.Status.NEW));
		System.out.println(desk.tickets(Ticket.Status.INPROGRESS));
		System.out.println("---");

		System.out.println("Done.");
	}
}
