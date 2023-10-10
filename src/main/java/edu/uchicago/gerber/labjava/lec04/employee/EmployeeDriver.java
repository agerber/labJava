package edu.uchicago.gerber.labjava.lec04.employee;


public class EmployeeDriver {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //String name, double salary, int nYear, int nMonth, int nDay)
        //a simple test of inheretence


        //super and this are explained in the subclasses


        //what happens when we do not override the getDescription method
        Employee[] empChicagos = {

                new Employee("Joe Smith", 45000, 2013, 10, 15),
                new Employee("Herman Brown", 56000, 2013, 10, 15),
                new Manager("Harry Cracker", 82000, 2013, 10, 15, 8000),
                new Executive("Ryan Exavier", 120000, 2013, 10, 15, 18000, 9190000)
                //new Student("Adam Student", "CompSci")

        };


        for (Employee emp : empChicagos) {
            System.out.println(emp.getDescription());
        }

        System.out.println("#############################");


        //this will call the toString method
        for (Employee emp : empChicagos) {
            System.out.println(emp);
        }


        System.out.println("#############################");
        //create a new arrayList of persons
        //ArrayList<Person> perChicagos = new ArrayList<Person>();

        Person[] perChicagos = new Person[empChicagos.length + 2];


        //add all the employees from Chicago
        for (int nC = 0; nC < empChicagos.length; nC++) {
            perChicagos[nC] = empChicagos[nC];
        }

        //add a new student
        perChicagos[empChicagos.length] = new Student("Marry Macker", "UChicago");
        perChicagos[empChicagos.length + 1] = new Student("Joe Student", "DePaul");


        System.out.println("#############################");

        for (Person per : perChicagos) {

            if (per instanceof Student && ((Student) per).getSchool().equals("UChicago")) {

                System.out.println(per.getDescription() + " you get 10k");
            }
            else {
                System.out.println(per.getDescription());
            }
        }
    }

    //promoting cast (automatic).  This is cool!
    //Object[] objPeeps = (Object[]) empChicagos;
    //	Object[] objPeeps =  perChicagos;


    //let's strore the persons in object references and call toString()
//        System.out.println("#############################");
//        for (Object obj : objPeeps) {
//            System.out.println(obj);
//        }


    //Runtime error (will throw unchecked exception ClassCastException)
    //the reason is that some of the employees may not be executives
//        Executive[] excPeeps = (Executive[])empChicagos;
//        System.out.println("#############################");
//        for (Executive exc : excPeeps) {
//            System.out.println(exc.getStockValue());
//        }
//        System.out.println("#############################");
//        for (Employee emp : empChicagos) {
//             if (emp instanceof Executive){
//                 System.out.println(((Executive)emp).getStockValue());
//             }
//        }


//    }

}
