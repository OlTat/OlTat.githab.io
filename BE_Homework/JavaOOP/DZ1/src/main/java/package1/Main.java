package package1;

/*
 *   1. Создать класс Person, который инкапсулирует информацию о человеке - актёре в системе.
 *   Добавить поля для описания характерных особенностей человека.
 *   2. Создать 2 уникальных Person, с разными именами, профессиями и гендерами. Распечатать *   информацию о них на консоль.
 */

public class Main {
    public static void main(String[] args) {
        Person actor = new Person("Andre", "man", 42, 181, 85, "actor");
        System.out.println(actor);

        Person ballerina = new Person("Loren", "woman", 26, 172, 64, "ballerina");
        System.out.println(ballerina);
    }
}

class Person {
    private String name;
    private String gender;
    private int age;
    private int growth;
    private int weight;
    private String profession;
    public Person(String name, String gender, int age, int growth, int weight, String profession) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.growth = growth;
        this.weight = weight;
        this.profession = profession;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getGrowth() {
        return growth;
    }
    public void setGrowth(int growth) {
        this.growth = growth;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String toString() {
        return "Person [name " + name + ", gender " + gender + ", age " + age + ", growth " + growth + ", " +
                "weight " + weight + ", profession " + profession + "]";
    }
}
