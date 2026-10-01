class TicketBooking {
    int tickets = 5;
    synchronized void bookTicket(String customer,int numberOfTickets) {
        if(tickets >= numberOfTickets) {
            System.out.println(customer + " booking " + numberOfTickets + "tickets");
            tickets = tickets - numberOfTickets;

            System.out.println("booking successful " + customer);
            System.out.println("Tickets left" + tickets);
        } else{
            System.out.println(" Sorry " + customer + " low tickets available ");
        }
    }
}

class Customer extends  Thread {
    TicketBooking booking;
    String customerName;
    int numberOfTickets;

     Customer(TicketBooking booking, String customerName, int numberOfTickets) {
        this.booking = booking;
        this.customerName = customerName;
        this.numberOfTickets = numberOfTickets;
    }

    public void run() {
        booking.bookTicket(customerName, numberOfTickets);
    }


}
public class TicketBookingExample {
    public static void main(String[] args) {

        TicketBooking booking = new TicketBooking();

        Customer c1 = new Customer(booking, "Customer 1", 2);
        Customer c2 = new Customer(booking, "Customer 2", 2);
        Customer c3 = new Customer(booking, "Customer 3", 2);

        c1.start();
        c2.start();
        c3.start();
    }
}