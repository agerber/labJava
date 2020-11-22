package lec03.glab.employee;

import java.util.ArrayList;



public class EmployeeTestSimple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		Executive thad = new Executive("Thad Chatwick", 200_000, 50_000, 3_000_000);
		Executive bret = new Executive("Bret Underwood", 200_000, 50_000, 40_000_000 );



		System.out.println(bret.promote().promote().getDescription());






		Manager victor = new Manager("Victor Orban", 200_000, 20_000);

		System.out.println(bret.getDescription() + bret.healthPlan());
		System.out.println(victor.getDescription() + victor.healthPlan());


		System.out.println(thad.greetOther(victor));
		System.out.println(thad.greetOther(bret, true));

		ArrayList<Executive> arrayList = new ArrayList<>();
		arrayList.add(thad);
		arrayList.add(bret);

		for (Executive executive : arrayList) {
			System.out.println(executive.getDescription());

		}



		
		//String name, double salary, int nYear, int nMonth, int nDay)
		//a simple test of inheretence 
	///    Person person = new Person("Adam");

		//super and this are explained in the subclasses
		
		Student student = new Student("Adam", "CS");

		System.out.println(student.getName());

		
		//what happens when we do not override the getDescription method
		Employee[] empChicagos = { 
				
			new Employee("Joe Smith", 45000, 2011, 10, 15 ),
			new Employee("Herman Brown", 56000, 2011, 10, 15 ),
			new Manager("Harry Cracker", 82000, 2011, 10, 15, 8000 ),
			new Executive("Ryan Exavier", 120_000, 18_000, 9_190_000 )

				
		};
		
		
		for (Employee emp : empChicagos) {
			System.out.println(emp.getDescription());
		}
		
		System.out.println("#############################");
		
		
		for (Employee emp : empChicagos) {
			System.out.println(emp.toString());
		}
		
		
		System.out.println("#############################");
		ArrayList<Person> perChicagos = new ArrayList<Person>();
		
		for (int nC = 0; nC < empChicagos.length; nC++) {
			perChicagos.add(empChicagos[nC]);
		}
		
	
        
		perChicagos.add(new Student("Joe Student", "CompSci"));
		
		
		System.out.println("#############################");
		
		for (Person per : perChicagos) {
			System.out.println(per.getDescription());
		}
		
		

		
		//promoting cast (automatic).  This is cool!
		//Object[] objPeeps = (Object[]) empChicagos;
		Object[] objPeeps =  empChicagos;

        System.out.println("#############################");


        for (Object obj : objPeeps) {
            System.out.println(obj);
        }



        //Runtime error (will throw unchecked exception ClassCastException)
		///UNCOMMENT THIS CODE
//        Executive[] excPeeps = (Executive[])empChicagos;
//        System.out.println("#############################");
//        for (Executive exc : excPeeps) {
//            System.out.println(exc.getStockValue());
//        }








    }

}
