public class HNode<Key, E> {

    // instance variables
    // class needs to be the key valued pair (key, E)

    Key key;
    E e;
    boolean tombstone;
    int hashvalue;
    int numberOfProbes = 0;

    //default constructor
    HNode(){
        key = null;
        e = null;
        tombstone = false;
    }

    public HNode(Key key, E e){
        this.key = key;
        this.e = e;
        tombstone = false;
    }


    public void tostring(){
        System.out.print("(" + this.key + ", " + this.e + ")");
    }




    // getters and setters

    public void setNumberOfProbes(int num){
        this.numberOfProbes = num;
    }

    public void setHashvalue(int num){
        this.hashvalue = num;
    }

    public void setKey(Key k){
        this.key = k;
    }

    public void setE(E e){ this.e = e; }

    public boolean isTombstone() {
        boolean valid = false;
        if (tombstone)
            valid = true;
        return valid;
    }

    public void setTombstone(){ this.tombstone = true;}

    public int getHashvalue(){
        return this.hashvalue;
    }

    public Key getKey(){
        return this.key;
    }

    public E getE(){
        return this.e;
    }

    public int getNumberOfProbes(){ return this.numberOfProbes; }




}
