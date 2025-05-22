import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        // Null item list throws exception
        assertEquals("allItems list can't be null!",
                assertThrows(RuntimeException.class, () ->
                        SILab2.checkCart(null, "1234123412341234")).getMessage());

        // Item with null name throws exception
        Item badItem = new Item(null, 1, 0, 0);
        assertEquals("Invalid item!",
                assertThrows(RuntimeException.class, () ->
                        SILab2.checkCart(List.of(badItem), "1234123412341234")).getMessage());

        // Items valid, card invalid
        Item chocolate = new Item("Chocolate", 15, 500, 0.50);
        Item candy = new Item("Candy", 2, 100, 0);
        List<Item> itemList = List.of(chocolate, candy);

        assertEquals("Invalid card number!",
                assertThrows(RuntimeException.class, () ->
                        SILab2.checkCart(itemList, null)).getMessage());

        // Card has invalid characters
        assertEquals("Invalid character in card number!",
                assertThrows(RuntimeException.class, () ->
                        SILab2.checkCart(itemList, "hello23912385432")).getMessage());

        // Returns valid total, every statement visited
        assertEquals(3920, SILab2.checkCart(itemList, "1298421398412398"));
    }

    @Test
    public void testMultipleCondition() {
        // item.getPrice() > 300 || X || X
        List<Item> test1 = List.of(new Item("Licorice", 7, 1000, 0));
        assertEquals(6970, SILab2.checkCart(test1, "1298421398412398"));

        // F || item.getDiscount() > 0 || X
        List<Item> test2 = List.of(new Item("Stobi Flips", 6, 39, 0.5));
        assertEquals(87, SILab2.checkCart(test2, "1298421398412398"));

        // F || F || item.getQuantity() > 10
        List<Item> test3 = List.of(new Item("Orbit", 20, 50, 0));
        assertEquals(970, SILab2.checkCart(test3, "1298421398412398"));

        // F || F || F
        List<Item> test4 = List.of(new Item("Peanut Butter", 1, 199, 0));
        assertEquals(199, SILab2.checkCart(test4, "1298421398412398"));
    }
}
