package p05ComparingObjects.Person;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person p) {
        int res = this.name.compareTo(p.name);

        if (res == 0) {
            res = this.age > p.age ? 1 : this.age < p.age ? -1 : 0;

            if (res == 0) {
                res = this.town.compareTo(p.town);
            }
        }

        return res;
    }

}
