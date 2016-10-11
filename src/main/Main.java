public class Main {
    public static void main(String[] args) {

        CommandLineInterface userinterface = new CommandLineInterface();

        while (userinterface.running = true) {

            userinterface.setFile();
            userinterface.chooseMethod();
        }

        System.out.print("Exiting Program");

    }
}
