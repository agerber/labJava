package edu.uchicago.gerber.labjava.lec04.brady;

public class Brady {
    private String name;

    private Brady junior;


    public Brady(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brady getJunior() {
        return junior;
    }

    public Brady setJunior(Brady junior) {


        if (this.junior == null){
            setJunior(junior);
        } else {

            Brady juniorCounter = getJunior();
            while (juniorCounter != null ){
                juniorCounter = juniorCounter.getJunior();
            }
            juniorCounter.setJunior(junior);
        }

        return this;


       // juniorCounter.setJunior(junior);
    }

//    public void setJuniors(Brady... juniors){
//
//        Brady youngest = this;
//        //while juniuo is not null
//        while (null != youngest.getJunior()){
//            youngest = youngest.getJunior();
//        }
//        for (Brady brady : juniors) {
//            youngest.setJunior(brady);
//            youngest = youngest.getJunior();
//
//        }
//
//
//    }

    @Override
    public String toString() {
        String brady =  "Brady{" +
                "name='" + name + '\'' +

                '}';

        StringBuilder stringBuilder = new StringBuilder();
        Brady junior = this;

        //while getJunior() != null
        while(null != junior.getJunior()){
            stringBuilder.append("Dependents ");
            stringBuilder.append(junior.getName());
            junior = junior.getJunior();

        }

        return brady + stringBuilder.toString();



    }
}
