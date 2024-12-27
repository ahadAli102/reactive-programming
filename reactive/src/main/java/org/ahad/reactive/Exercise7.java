package org.ahad.reactive;

import java.io.IOException;

public class Exercise7 {

    public static void main(String[] args) throws IOException {

        // use intNumberMono() & intNumbersFlux()

        // Print all values from intNumberFlux that's greater than 5
        ReactiveSources.intNumbersFlux()
                .filter(e -> e > 5)
                .subscribe(System.out::println);


        // Print 10 multiplied each value from intNumbersFlux thats greater than 5
        ReactiveSources.intNumbersFlux()
                .filter(e -> e > 5)
                .map(e -> e * 10)
                .subscribe(System.out::println);

        
        // Print 10 times each value from intNumbersFlux's first 3 numbers thats greater than 5
        ReactiveSources.intNumbersFlux()
                .filter(e -> e > 5)
                .take(3)
                .map(e -> e * 10)
                .subscribe(System.out::println);

        
        // Print each value from intNumbersFlux that's greater than 20. 
        // Print -1 if no elements are found
        ReactiveSources.intNumbersFlux()
                .filter(e -> e > 20)
                .defaultIfEmpty(-1)
                .subscribe(System.out::println);

        // Switch ints from intNumbersFlux to the right user from userFlux
        ReactiveSources.intNumbersFlux()
                .flatMap(n -> ReactiveSources.userFlux().filter(user -> user.getId() == n))
                .subscribe(System.out::println);

        // Print only distinct numbers from intNumbersFluxWithRepeat
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()
                .subscribe(System.out::println);

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(System.out::println);
        

          System.out.println("Press a key to end");
          System.in.read();

    }

}