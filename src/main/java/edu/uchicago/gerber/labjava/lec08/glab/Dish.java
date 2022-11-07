package edu.uchicago.gerber.labjava.lec08.glab;


public class Dish implements Comparable<Dish> {

    private final String name;
    private final boolean vegetarian;
    private int calories;
    private final Dish.Type type;

    public Dish(String name, boolean vegetarian, int calories, Dish.Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Dish.Type getType() {
        return type;
    }

    @Override
    public int compareTo(Dish dish) {
        return getName().compareTo(dish.getName());
    }


    public enum Type {MEAT, FISH, OTHER}

    public void setCalories(int value) {
        calories = value;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}
