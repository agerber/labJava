package lec09.glab.morepatterns.builder;

public class BuilderDriver {
    public static void main(String[] args) {
        Product product = Product.builder()

                .id("123")
                .description("Samsung Galaxy Note with pen")
                .value(1000.00)
                .name("Samsung Galaxy")

                .build();


        System.out.println(product);


    }
}
