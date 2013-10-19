package lec04.glab.employee;

import lec03.glab.employee.*;
import lec03.glab.employee.Employee;
import lec03.glab.employee.Executive;
import lec03.glab.employee.Person;
import lec03.glab.employee.Student;

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
		lec03.glab.employee.Employee[] empChicagos = {
				
			new lec03.glab.employee.Employee("Joe Smith", 45000, 2011, 10, 15 ),
			new lec03.glab.employee.Employee("Herman Brown", 56000, 2011, 10, 15 ),
			new lec03.glab.employee.Manager("Harry Cracker", 82000, 2011, 10, 15, 8000 ),
			new lec03.glab.employee.Executive("Ryan Exavier", 120000, 2011, 10, 15, 18000, 9190000 )
			//new Student("Adam Student", "CompSci")
				
		};
		
		
		for (lec03.glab.employee.Employee emp : empChicagos) {
			System.out.println(emp.getDescription());
		}
		
		System.out.println("#############################");
		
		
		for (Employee emp : empChicagos) {
			System.out.println(emp);
		}
		
		
		System.out.println("#############################");
		ArrayList<lec03.glab.employee.Person> perChicagos = new ArrayList<lec03.glab.employee.Person>();
		
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
        lec03.glab.employee.Executive[] excPeeps = (lec03.glab.employee.Executive[])empChicagos;

        System.out.println("#############################");
        for (Executive exc : excPeeps) {
            System.out.println(exc.getStockValue());
        }








    }

}
