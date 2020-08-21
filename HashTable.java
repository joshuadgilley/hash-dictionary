import java.util.*;

public class HashTable<Key, E> {

    // needed methods -> insert, remove, find
    // need an array to hold values
    // need a permutated array for probing
    // this is where the hashing and probing will take place

     /////////////////////////////////////////////////////////////
    // INSTANCE VARIABLES ///////////////////////////////////////

    private HNode[] table;
    private int[] perm;
    private int maxsize;
    private int size = 0;
    private static final int DEFAULT_SIZE = 15;


     /////////////////////////////////////////////////////////////
    // CONSTRUCTORS /////////////////////////////////////////////

    // default
    public HashTable(){
        this(DEFAULT_SIZE);
        table = new HNode[maxsize];
        perm = new int[maxsize];
        permutation(perm);
        fillNull();
    }


    public HashTable(int size){
        this.maxsize = size;
        table = new HNode[size];
        perm = new int[size];
        permutation(perm);
        fillNull();

    }


     ////////////////////////////////////////////////////////////
    // INSERTS /////////////////////////////////////////////////

    // pseudoProbe insert
    public void pseudoInsert(Key k, E e) {
        HNode temp = new HNode(k, e);
        int pos;
        int index = pos = standardHash(k);
        int count = 0;
        // int index = intHash(e, maxsize);


        if (size == maxsize){
            System.out.println("The HashTable Is Full!");
        }

        else {
            for (int i = 0; null != table[pos].getKey(); i++) {
                if (table[pos].getKey() != null) {
                    count++;
                    pos = pseudoProbe(i, index);
                }
                if (table[pos].getKey() == k){
                    System.out.println("Error: " + k + " already exists at index " + pos);
                    return;
                }
            }

            table[pos] = temp;
            size++;
            table[pos].setNumberOfProbes(count);
            table[pos].setHashvalue(index);

        }
    }

    // quadratic insert
    public void quadraticInsert(Key k, E e){
        HNode temp = new HNode(k, e);
        int pos;
        int index = pos = standardHash(k);
        int count = 0;
        // int index = intHash(e, maxsize);


        if (size == maxsize){
            System.out.println("The HashTable Is Full!");
        }

        else {
            for (int i = 0; null != table[pos].getKey(); i++) {
                if (table[pos].getKey() != null) {
                    count++;
                    pos = quadraticProbe(i, index);
                }
                if (table[pos].getKey() == k){
                    System.out.println("Error: " + k + " already exists at index " + pos);
                    return;
                }
            }

            table[pos] = temp;
            size++;
            table[pos].setNumberOfProbes(count);
            table[pos].setHashvalue(index);

        }
    }

    // linear insert
    public void linearInsert(Key k, E e) {
        HNode temp = new HNode(k, e);
        int pos;
        int index = pos = standardHash(k);
        int count = 0;
        // int index = intHash(e, maxsize);


        if (size == maxsize){
            System.out.println("The HashTable Is Full!");
        }

        else {
            for (int i = 0; null != table[pos].getKey(); i++) {
                if (table[pos].getKey() != null) {
                    count++;
                    pos = linearProbe(i, index);
                }
                if (table[pos].getKey() == k){
                    System.out.println("Error: " + k + " already exists at index " + pos);
                    return;
                }
            }

            table[pos] = temp;
            size++;
            table[pos].setNumberOfProbes(count);
            table[pos].setHashvalue(index);

        }
    }


     ///////////////////////////////////////////////////////////
    // REMOVES & FIND /////////////////////////////////////////

    // findObject
    public E findObject(Key k) {

        boolean found = false;
        int pos;

        int index = pos =  standardHash(k);

        for (int i = 0; i < maxsize; i++) {
            if (table[pos].getKey() != k) {
                pos = pseudoProbe(i, index);
            }

        }
        return (E) table[pos].getE();
    }

    // remove (using findObject)
    public E pseudoRemove(Key k) {
        int home;
        int pos;

        home = pos = standardHash(k);

        if (size == 0){
            System.out.println("The dictionary already is empty..");
            return null;
        }

        for (int i = 0; i < maxsize; i++){
            if (table[pos].getKey() != k){
                pos = pseudoProbe(i, home);
            }
        }

        if (table[pos].getKey() != k){
            System.out.println("The item you're searching for is not in the dictionary...");
            return null;
        }


        HNode temp = table[pos];
        table[pos] = new HNode();
        table[pos].setTombstone();
        table[pos].setE("TOMBSTONE");
        size--;
        return (E) temp.getE();

    }

    public E quadRemove(Key k) {

        int home;
        int pos;

        home = pos = standardHash(k);

        if (size == 0){
            System.out.println("The dictionary already is empty..");
            return null;
        }

        for (int i = 0; i < maxsize; i++){
            if (table[pos].getKey() != k){
                pos = quadraticProbe(i, home);
            }
        }

        if (table[pos].getKey() != k){
            System.out.println("The item you're searching for is not in the dictionary...");
            return null;
        }


        HNode temp = table[pos];
        table[pos] = new HNode();
        table[pos].setTombstone();
        table[pos].setE("TOMBSTONE");
        size--;
        return (E) temp.getE();

    }

    public E linearRemove(Key k) {
        int home;
        int pos;

        home = pos = standardHash(k);

        if (size == 0){
            System.out.println("The dictionary already is empty..");
            return null;
        }

        for (int i = 0; i < maxsize; i++){
            if (table[pos].getKey() != k){
                pos = pseudoProbe(i, home);
            }
        }

        if (table[pos].getKey() != k){
            System.out.println("The item you're searching for is not in the dictionary...");
            return null;
        }


        HNode temp = table[pos];
        table[pos] = new HNode();
        table[pos].setTombstone();
        table[pos].setE("TOMBSTONE");
        size--;
        return (E) temp.getE();

    }

     ////////////////////////////////////////////////////////////
    // HELPER & SETUP METHODS ///////////////////////////////////



    public E removeAny() {

        if (size != 0)
            return quadRemove((Key) "x");
        else
            return null;
    }


    // method that makes a permutation array of indexes
    private void permutation(int[] intArr){
        // establish the array with initial indexes
        for (int i = 0; i < intArr.length; i++){
            perm[i] = i;
        }
        shuffleArray(perm);
    }

    private void fillNull(){
        for (int i = 0; i < maxsize; i++){
            table[i] = new HNode();
        }
    }

    private void shuffleArray(int[] array)
    {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }

     ////////////////////////////////////////////////////////
    // HASH CODES //////////////////////////////////////////

    private int intHash(Object x, int M){
        return (int) x % M;
    }

    private int standardHash(Key k) {
        return Math.abs(k.hashCode() % maxsize);
    }

    // only works if we are inserting strings
    private int sascii(Object x, int M) {
        char ch[];

        ch = ((String) x).toCharArray();
        int xlength = ((String) x).length();

        int i, sum;
        for (sum=0, i=0; i < xlength; i++)
            sum += ch[i];
        return sum % M;
    }

     //////////////////////////////////////////////////////////////
    // PROBES ////////////////////////////////////////////////////
    private int pseudoProbe(int i, int hash){
        return (hash + perm[i]) % maxsize;
    }

    private int quadraticProbe(int i, int hash){
        return Math.abs((hash + (i*i))) % maxsize;
    }

    private int linearProbe(int i, int hash){
        return (hash + i) % maxsize;
    }

     /////////////////////////////////////////////////////////////
    // GETTERS & SETTERS ////////////////////////////////////////

    public void getTable(){
        int totalProbes = 0;

        for (int i = 0; i < maxsize; i++){
            tostring(i);
            totalProbes += table[i].numberOfProbes;
        }
        System.out.println("**Total # of Probes: " + totalProbes + "**");
        System.out.println("-------------------------------------------");
    }

    public void tostring(int index) {
        System.out.print("[(" + index + ")");
        table[index].tostring();
        System.out.print(" Info -> Hash Value: " + table[index] .getHashvalue() + " || NumOfProbes: " + table[index].getNumberOfProbes() + "]");
        System.out.println();
    }
}
