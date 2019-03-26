package Klasser;

public class Person {

    private String persnr;
    private String name;
    private int age;

    public Person(String persnr, String name, int age) {
        this.persnr = persnr;
        this.name = name;
        this.age = age;
    }

    public String getPersnr() {
        return persnr;
    }

    public void setPersnr(String persnr) {
        this.persnr = persnr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
