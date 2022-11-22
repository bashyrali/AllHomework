

public class MyCollection {
    public static void main(String[] args) {
        Cat[] cats = new Cat[10];
        String name = "Barsik";
        
        print(addCat(name, cats, 0));
    }
    
    
    public static Cat addCat(String addName,Cat cats[],int i ) {
        cats[i]= new Cat();
        cats[i].name =addName;
        return cats[i];
        
    }
    public static void printCats(Cat[] cats) {
        for (Cat i : cats) {
            print(i);
        }
    }
    public static void print(Cat cat) {
        
        System.out.println(cat.name);
    }
}
