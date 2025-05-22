# Ивана Мирческа 233170

## Control Flow Graph
![image](https://github.com/user-attachments/assets/3bf03009-cb34-4bc0-8576-244ca672b7d4)

## Цикломатска комплексност
Користејќи ја формулата P+1, каде P претставува бројот на предикатни јазли. На графот можат да се приметат 8 предикатни јазли, па цикломатската комплексност ќе изнесува 8+1 = 9.

## Тест случаи според критериумот Every statement
За да се постигне минимум за критериумот Every Statement доволно се 5 тест случаи:
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
