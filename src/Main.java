import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Elephant> herd = new ArrayList<>();
        herd.add(new Elephant("Рама", 290));
        herd.add(new Elephant("Дима", 200));
        herd.add(new Elephant("Маша", 199));
        List<Elephant>  elephantList = new LinkedList<>();
        elephantList.addAll(herd);
        System.out.println(elephantList);
        elephantList.add(herd.get(1));
        System.out.println(elephantList);
        Elephant e = new Elephant("Хари", 256);
        elephantList.add(e);elephantList.add(e);
        elephantList.sort(Comparator.comparing(Elephant::getName));
        System.out.println(elephantList);


        int counter = countDistinct(elephantList);
        System.out.println("counter = "+counter);
        System.out.println("counter2 = "+ countDistinctS(elephantList));
       /* Set<Elephant> distinctElephants = new HashSet<>();
        distinctElephants.addAll(elephantList);
        System.out.println(distinctElephants);*/
    }

    private static int countDistinct(List<Elephant> elephantList) {
        //Узнать, сколько разных слонов в списке?
        int counter=0;
        for (int i = 0; i < elephantList.size(); i++) {
            for (int j = i+1; j < elephantList.size(); j++)
                if ( elephantList.get(i).equals(elephantList.get(j)))
                    counter++;
        }
        return elephantList.size()-counter;
        //O(N) = N*N/2
    }

    private static <T>int countDistinctS(List<T> tList) {
        //Узнать, сколько разных слонов в списке?
        int counter=0;
        if (tList.isEmpty())
            return 0;
        tList.sort(Comparator.comparing(T::toString));// O(N) = N*log(N)
        for (int i = 1; i < tList.size(); i++) {             // O(N) = N
            if(!tList.get(i).equals(tList.get(i-1)))
                counter++;
        }
        return counter+1;
        // O(N) = N* (1+ log(N))
    }

}


class Elephant{
    String name;
    double weight;

    public Elephant(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getName() {
        return name;
    }
}