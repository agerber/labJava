package lec03.employee;

import java.util.ArrayList;



public class EmployeeTestSimple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//String name, double salary, int nYear, int nMonth, int nDay)
		//a simple test of inheretence 
		

		//super and this are explained in the subclasses
		
		
		
		//what happens when we do not override the getDescription method
		Employee[] empChicagos = { 
				
			new Employee("Joe Smith", 45000, 2011, 10, 15 ),
			new Employee("Herman Brown", 56000, 2011, 10, 15 ),
			new Manager("Harry Cracker", 82000, 2011, 10, 15, 8000 ),
			new Executive("Ryan Exavier", 120000, 2011, 10, 15, 18000, 9190000 )
			//new Student("Adam Student", "CompSci")
				
		};
		
		
		for (Employee emp : empChicagos) {
			System.out.println(emp.getDescription());
		}
		
		System.out.println("#############################");
		
		
		for (Employee emp : empChicagos) {
			System.out.println(emp);
		}
		
		
		System.out.println("#############################");
		ArrayList<Person> perChicagos = new ArrayList<Person>();
		
		for (int nC = 0; nC < empChicagos.length; nC++) {
			perChicagos.add(empChicagos[nC]);
		}
		
	
        
		perChicagos.add(new Student("Adam Student", "CompSci"));
		
		
		System.out.println("#############################");
		
		for (Person per : perChicagos) {
			System.out.println(per.getDescription());
		}
		
		

		
		//cast down
		//Employee[] empPeeps = (Employee[])perChicagos;
		
		
		
		//examples of casting down
		
		//cast down again

		
		
		
		
		
		

	}

}
