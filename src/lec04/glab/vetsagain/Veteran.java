package lec04.glab.vetsagain;

import lec04.glab.veterans.Person;

public class Veteran {

    private String name;
    private int age;

    private Veteran junior;


    public Veteran(String name, int age) {
        this.name = name;
        this.age = age;
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

    public Veteran getJunior() {
        return junior;
    }

    public void setJunior(Veteran junior) {
        this.junior = junior;
    }

    public void setJuniors(Veteran... deps){


        Veteran youngest = this;
        while (null != youngest.getJunior()){
            youngest = youngest.getJunior();
        }

            for (Veteran dep : deps) {
               youngest.setJunior(dep);
               youngest = youngest.getJunior();

            }

    }


    @Override
    public String toString() {




        String vet = "Veteran{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';

        StringBuilder strBuilder = new StringBuilder();

        Veteran vetDep = junior;

        while (null != vetDep){

            strBuilder.append("\n\t\tDependant " + vetDep.name + ", " + vetDep.age);
            vetDep = vetDep.getJunior();
        }
        return vet + strBuilder.toString();

    }
}
