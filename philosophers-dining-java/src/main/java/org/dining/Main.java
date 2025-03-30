package org.dining;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        var argsLen = args.length;

        if (argsLen == 4 || argsLen == 5) {
            var diningFacade = DiningFacade.ofArgs(args);
            var philosophers = diningFacade.init();

            for (var philosopher : philosophers) {
                new Thread(philosopher).start();
            }

            new Thread(new Reaper(diningFacade.getTimeToDie(), philosophers)).start();
        } else {
            System.out.println("Wrong number of arguments");
            System.out.println("Usage: java -jar dining-philosophers.jar <number_of_philosophers> <time_to_die> <time_to_eat> <time_to_sleep> <number_of_times_each_philosopher_must_eat>");
        }
    }
}