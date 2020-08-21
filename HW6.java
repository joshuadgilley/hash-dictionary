public class HW6 {

    public static void main(String[] args)
    {

        HashDictionary diction = new HashDictionary(10);

        System.out.println(" /////////////////////////////////////////////////////////");
        System.out.println("KEY VALUE PAIR (STRING, INT) W/ LINEAR PROBING //////////");
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println();

        System.out.println("INSERT KEY VALUE PAIR (z , zebra) TO TABLE:");
        diction.insert("z", 1023);
        diction.printInfo();
        System.out.println();

        System.out.println("REMOVE KEY:(z) FROM TABLE");
        diction.remove("z");
        diction.printInfo();
        System.out.println();


        System.out.println("ATTEMPT TO REMOVE FROM EMPTY TABLE");
        diction.remove("c");
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("FILL DICTIONARY WITH ITEMS:");
        diction.insert("f", 5142);
        diction.insert("m", 33);
        diction.insert("j", 153);
        diction.insert("t", 9876);
        diction.insert("a", 16);
        diction.insert("x", 234);
        diction.insert("q", 453);
        diction.insert("k", 713);
        diction.insert("h", 175);
        diction.insert("z", 1000);
        diction.printInfo();
        System.out.println();

        System.out.println("ATTEMPT TO REMOVE KEY THAT ISNT IN THE TABLE");
        diction.remove("c");
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("ATTEMPT TO INSERT TO A FULL TABLE:");
        diction.insert("kw", 87);
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("REMOVE ITEM AND ATTEMPT TO INSERT A DUPLICATE");
        diction.remove("k");
        diction.insert("f", 15525);
        diction.printInfo();
        System.out.println();

        System.out.println("REMOVE A FEW ITEMS TO CREATE FEW TOMBSTONES:");
        diction.remove("q");
        diction.remove("a");
        diction.remove("h");
        diction.printInfo();;
        System.out.println();

        System.out.println("INSERT A FEW ITEMS BACK IN TO FILL TOMBSTONES:");
        diction.insert("q", 987);
        diction.insert("a", 684);
        diction.insert("h", 10034);
        diction.insert("r", 14);
        diction.printInfo();
        System.out.println();

        System.out.println("CLEAR THE TABLE:");
        diction.clear();
        diction.printInfo();
        System.out.println();


        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println(" /////////////////////////////////////////////////////////");
        System.out.println("KEY VALUE PAIR (STRING, STRING) W/ QUADRATIC PROBING ////");
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println();

        System.out.println("INSERT KEY VALUE PAIR (z , zebra) TO TABLE:");
        diction.quadInsert("z", "zebra");
        diction.printInfo();
        System.out.println();

        System.out.println("REMOVE KEY:(z) FROM TABLE");
        diction.quadRemove("z");
        diction.printInfo();
        System.out.println();


        System.out.println("ATTEMPT TO REMOVE FROM EMPTY TABLE");
        diction.quadRemove("c");
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("FILL DICTIONARY WITH ITEMS:");
        diction.quadInsert("f", "coke goes pop");
        diction.quadInsert("m", "michael");
        diction.quadInsert("j", "jordan");
        diction.quadInsert("t", "terrible");
        diction.quadInsert("a", "apple");
        diction.quadInsert("x", "xenon");
        diction.quadInsert("q", "quail");
        diction.quadInsert("k", "kangaroo");
        diction.quadInsert("h", "horse");
        diction.quadInsert("z", "zebra is cool");
        diction.printInfo();
        System.out.println();

        System.out.println("ATTEMPT TO REMOVE KEY THAT ISNT IN THE TABLE");
        diction.quadRemove("c");
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("ATTEMPT TO INSERT TO A FULL TABLE:");
        diction.quadInsert("kw", "keller williams");
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("REMOVE ITEM AND ATTEMPT TO INSERT A DUPLICATE");
        diction.quadRemove("k");
        diction.quadInsert("f", "coke goes pop");
        diction.printInfo();
        System.out.println();

        System.out.println("REMOVE A FEW ITEMS TO CREATE FEW TOMBSTONES:");
        diction.quadRemove("q");
        diction.quadRemove("a");
        diction.quadRemove("h");
        diction.printInfo();;
        System.out.println();

        System.out.println("INSERT A FEW ITEMS BACK IN TO FILL TOMBSTONES:");
        diction.quadInsert("q", "quail");
        diction.quadInsert("a", "apple");
        diction.quadInsert("h", "horse");
        diction.quadInsert("r", "recess");
        diction.printInfo();
        System.out.println();

        System.out.println("TESTING HELPER METHODS: REMOVEANY(), SIZE(), AND FIND()");
        System.out.println("Size: " + diction.size());
        System.out.println("RemoveAny chose: " + diction.removeAny());
        System.out.println("Find (r): " + diction.find("r"));
        diction.printInfo();
        System.out.println();



        System.out.println("CLEAR THE TABLE:");
        diction.clear();
        diction.printInfo();
        System.out.println();


        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println("KEY VALUE PAIR (INT, STRING) W/ PSEUDORANDOM PROBING ////");
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println();

        System.out.println("INSERT KEY VALUE PAIR (1 , zebra) TO TABLE:");
        diction.pseudoInsert(1, "zebra");
        diction.printInfo();
        System.out.println();

        System.out.println("REMOVE KEY:(z) FROM TABLE");
        diction.pseudoRemove(1);
        diction.printInfo();
        System.out.println();


        System.out.println("ATTEMPT TO REMOVE FROM EMPTY TABLE");
        diction.pseudoRemove(12);
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("FILL DICTIONARY WITH ITEMS:");
        diction.pseudoInsert(3, "coke goes pop");
        diction.pseudoInsert(12, "michael");
        diction.pseudoInsert(5, "jordan");
        diction.pseudoInsert(7, "terrible");
        diction.pseudoInsert(16, "apple");
        diction.pseudoInsert(1, "xenon");
        diction.pseudoInsert(66, "quail");
        diction.pseudoInsert(14, "kangaroo");
        diction.pseudoInsert(71, "horse");
        diction.pseudoInsert(87, "zebra is cool");
        diction.printInfo();
        System.out.println();

        System.out.println("ATTEMPT TO REMOVE KEY THAT ISNT IN THE TABLE");
        diction.pseudoRemove(100);
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("ATTEMPT TO INSERT TO A FULL TABLE:");
        diction.pseudoInsert(56, "keller williams");
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("REMOVE ITEM AND ATTEMPT TO INSERT A DUPLICATE");
        diction.pseudoRemove(1);
        diction.pseudoInsert(66, "coke goes pop");
        diction.printInfo();
        System.out.println();

        System.out.println("REMOVE A FEW ITEMS TO CREATE FEW TOMBSTONES:");
        diction.pseudoRemove(87);
        diction.pseudoRemove(14);
        diction.pseudoRemove(3);
        diction.printInfo();;
        System.out.println();

        System.out.println("INSERT A FEW ITEMS BACK IN TO FILL TOMBSTONES:");
        diction.pseudoInsert(222, "quail");
        diction.pseudoInsert(47, "apple");
        diction.pseudoInsert(89, "horse");

        diction.pseudoInsert(10, "recess");
        diction.printInfo();
        System.out.println();

        System.out.println("CLEAR THE TABLE:");
        diction.clear();
        diction.printInfo();
        System.out.println();




    }
}
