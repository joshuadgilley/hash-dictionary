// **NOTE**
// I did not include "implements Dictionary<Key, E>" at the end of this class declaration because
// it requires implementing methods that return enumerations which were not necessary for this
// assignment so I avoided that in that the method specified for use were in the document and are
// provided and test below

public class HashDictionary<Key extends Comparable<? super Key>, E>  {

    private static final int defaultSize = 10;
    private HashTable T;    // the hash table
    private int count;              // # of records now in table
    private int size;            // Maximum size of dictionary

    HashDictionary() {
        this(defaultSize);
    }

    HashDictionary(int size) {
        T = new HashTable(size);
        count = 0;
        this.size = size;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        boolean valid = false;
        if (count == 0) {
            valid = true;
        }
        return valid;
    }

    public void clear() {           // reinitialize
        T = new HashTable(size);
        count = 0;
    }

    public void quadInsert(Key k, E e) {        // Insert an element
        assert count < size : "Hash table is full";
        T.quadraticInsert(k, e);
        count++;
    }

    public void pseudoInsert(Key k, E e) {        // Insert an element
        assert count < size : "Hash table is full";
        T.pseudoInsert(k, e);
        count++;
    }

    public void insert(Key k, E e) {        // Insert an element
        assert count < size : "Hash table is full";
        T.linearInsert(k, e);
        count++;
    }

    public E pseudoRemove(Key k) {// Remove an element
        E temp = (E) T.pseudoRemove(k);
        if (temp != null)
            return temp;
        return null;
    }

    public E quadRemove(Key k) {// Remove an element
        E temp = (E) T.quadRemove(k);
        if (temp != null)
            return temp;
        return null;
    }

    public E remove(Key k) {// Remove an element
        E temp = (E) T.linearRemove(k);
        if (temp != null)
            return temp;
        return null;
    }

    public E find(Key k){
        return (E) T.findObject(k);
    }

    public E removeAny() {
        if (size != 0){
            size--;
            return (E) T.removeAny();
        }
        else return null;
    }



    public void printInfo(){
        T.getTable();
    }


}
