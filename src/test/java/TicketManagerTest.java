import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManagerTest {

    @Test

    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortForTickets() {

        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);
    }

    @Test
    public void testCompare() {

        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "UFA", 100, 10, 16);

        Assertions.assertEquals(1, ticket1.compareTo(ticket2));
    }

    @Test

    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); //  2
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14); // 3
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17); // 10
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10); // 4
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8); // 1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket8, ticket1, ticket2, ticket6, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TicketTimeComparatorTest() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "UFA", 100, 10, 16);

        manager.add(ticket1);
        manager.add(ticket2);

        Assertions.assertEquals(-1, comparator.compare(ticket1, ticket2));
    }

    @Test
    public void searchAndSortByTest() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3500, 11, 13);
        Ticket ticket2 = new Ticket("MSK", "SPB", 2100, 9, 12);
        Ticket ticket3 = new Ticket("MSK", "SPB", 4000, 2, 22);
        Ticket ticket4 = new Ticket("MSK", "SPB", 7000, 11, 17);
        Ticket ticket5 = new Ticket("MSK", "SPB", 4500, 12, 13);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket5, ticket1, ticket2, ticket4, ticket3};
        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }


}
