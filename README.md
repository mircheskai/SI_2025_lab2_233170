# Ивана Мирческа 233170

## Control Flow Graph
![image](https://github.com/user-attachments/assets/3bf03009-cb34-4bc0-8576-244ca672b7d4)

## Цикломатска комплексност
Користејќи ја формулата P+1, каде P претставува бројот на предикатни јазли. На графот можат да се приметат 8 предикатни јазли, па цикломатската комплексност ќе изнесува 8+1 = 9.

## Тест случаи според критериумот Every statement
За да се постигне минимум за критериумот Every Statement доволни се 5 тест случаи:
#### Се тестираат изразите кои завршуваат со „allItems list can't be null!“ грешка
```java
// Null item list throws exception
assertEquals("allItems list can't be null!",
        assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234123412341234")).getMessage());
```
#### Се тестираат изразите кои завршуваат со „Invalid item!“ грешка
```java
// Item with null name throws exception
Item badItem = new Item(null, 1, 0, 0);
assertEquals("Invalid item!",
        assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(badItem), "1234123412341234")).getMessage());
```
#### Се тестираат изразите кои завршуваат со “Invalid card number!“ грешка
```java
// Items valid, card invalid
Item chocolate = new Item("Chocolate", 15, 500, 0.50);
Item candy = new Item("Candy", 2, 100, 0);
List<Item> itemList = List.of(chocolate, candy);

assertEquals("Invalid card number!",
        assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(itemList, null)).getMessage());
```
#### Се тестираат изразите кои завршуваат со “Invalid character in card number!“ грешка
```java
// Card has invalid characters
assertEquals("Invalid character in card number!",
        assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(itemList, "hello23912385432")).getMessage());
```
#### Се тестираат изразите кои завршуваат со успешно вратен резултат, и со овој тест се постигнува минималниот број тестови за Every Statement критериумот
```java
// Returns valid total, every statement visited
assertEquals(3920, SILab2.checkCart(itemList, "1298421398412398"));
```

### Тест случаи според критериумот Multiple Condition
За да се постигне минимум за критериумот Multiple Condition доволни се 4 тест случаи, бидејќи имаме два OR оператори, најпрво ако првиот израз е точен, другите два се редундантни, потоа ако првиот е грешен и вториот е точен (правејќи го третиот редундантен), потоа ако првиот и вториот се грешни и третиот е точен, и на крај кога сите три се грешни:
```java
// item.getPrice() > 300 || X || X
List<Item> test1 = List.of(new Item("Licorice", 7, 1000, 0));
assertEquals(6970, SILab2.checkCart(test1, "1298421398412398"));
```
```java
// F || item.getDiscount() > 0 || X
List<Item> test2 = List.of(new Item("Stobi Flips", 6, 39, 0.5));
assertEquals(87, SILab2.checkCart(test2, "1298421398412398"));
```
```java
// F || F || item.getQuantity() > 10
List<Item> test3 = List.of(new Item("Orbit", 20, 50, 0));
assertEquals(970, SILab2.checkCart(test3, "1298421398412398"));
```
```java
// F || F || F
List<Item> test4 = List.of(new Item("Peanut Butter", 1, 199, 0));
assertEquals(199, SILab2.checkCart(test4, "1298421398412398"));
```
