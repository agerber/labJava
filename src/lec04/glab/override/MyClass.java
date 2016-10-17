package lec04.glab.override;

/**
 * Created by Adam on 4/18/2016.
 */
public class MyClass implements  Drawable{
    @Override
    public void draw() {
        System.out.println( "  [     | \"=, \"=,,\n" +
                "  [-----+----\"=,* )");
    }


}
