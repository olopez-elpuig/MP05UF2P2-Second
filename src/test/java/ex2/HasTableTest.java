package ex2;

import org.junit.jupiter.api.Assertions;

public class HasTableTest {

    @org.junit.jupiter.api.Test
    void count_size() {
        HashTable hashTable = new HashTable();

        Assertions.assertEquals(0,hashTable.count());
        Assertions.assertEquals(16,hashTable.size());
        hashTable.put("1","key1");
        hashTable.put("2","key2");
        hashTable.put("3","key3");
        Assertions.assertEquals(3,hashTable.count());
        Assertions.assertEquals(16,hashTable.size());

    }

    @org.junit.jupiter.api.Test
    void putSinColision() {
        HashTable hashTable = new HashTable();

        Assertions.assertEquals("",hashTable.toString());
        hashTable.put("1","key1");
        hashTable.put("2","key2");
        hashTable.put("3","key3");
        hashTable.put("4","key4");


        Assertions.assertEquals("\n" +
                " bucket[1] = [1, key1]\n" +
                " bucket[2] = [2, key2]\n" +
                " bucket[3] = [3, key3]\n" +
                " bucket[4] = [4, key4]",hashTable.toString());

    }

    @org.junit.jupiter.api.Test
    void getSinColision() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","key1");
        hashTable.put("2","key2");
        hashTable.put("3","key3");
        hashTable.put("4","key4");

        hashTable.put("2","difKey");
        hashTable.put("3","difKey");

        Assertions.assertEquals("mundo1",hashTable.get("1"));
        Assertions.assertEquals("difKey",hashTable.get("3"));
    }

    @org.junit.jupiter.api.Test
    void getNoExiste() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","key1");
        hashTable.get("12");
        Assertions.assertEquals(null,hashTable.get("12"));
    }
    @org.junit.jupiter.api.Test
    void drop(String key){  //editar de manera que borre mas de uno.
        HashTable hashTable = new HashTable();
        hashTable.put(key, "4");
        //Comprobamos que hay uno
        Assertions.assertEquals(1, hashTable.count());
        //Se elimina el valor
        hashTable.drop(key);
        //Comprobamos que no hay ninguno
        Assertions.assertEquals(null, hashTable.get(key));
    }

}
