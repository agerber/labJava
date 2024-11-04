package edu.uchicago.gerber.labjava.lec10.patterns.chain_of_responsibility.example.middleware;

/**
 * EN: ConcreteHandler. Checks a user's role.
 *
 * RU: Конкретный элемент цепи обрабатывает запрос по-своему.
 */
public class RoleCheckMiddleware extends Middleware {
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
