package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceDesk {

	private List<Ticket> tickets = new ArrayList<Ticket>();

	public void add() {
		Ticket ticket = new Ticket();
		tickets.add(ticket);
		System.out.println("Ticket is added");
	}

	public void handle(Handler handler) {
		for (Ticket ticket : tickets) {
			if (ticket.status() == Ticket.Status.NEW) {
				ticket.handle(handler);
				break;
			}
		}

		System.out.println("ServiceDesk.handle(), " + handler);
	}

	public void close(Handler handler) {
		for (Ticket ticket : tickets) {
			if (ticket.getHandler() == handler && ticket.status() == Ticket.Status.INPROGRESS) {
				ticket.close();
				break;
			}
		}

		System.out.println("ServiceDesk.close(), " + handler);
	}

	public List<Ticket> tickets(Ticket.Status status) {
		return tickets.stream().filter(x -> x.status() == status).collect(Collectors.toList());
	}

	public List<Ticket> tickets(Handler handler) {
		return tickets.stream().filter(x -> x.getHandler() == handler && x.status() == Ticket.Status.INPROGRESS)
				.collect(Collectors.toList());
	}

	public Ticket check(int id) {
		return tickets.stream().filter(x -> x.getId() == id).findAny().orElse(null);
	}
	
	public void print() {
		System.out.println("Tickets:");
		if (tickets == null || tickets.size() == 0) {
			System.out.println("<EMPTY>");
		} else {
			for (Ticket ticket : tickets) {
				System.out.println(ticket);
			}
		}
		System.out.println("---");
	}
}
