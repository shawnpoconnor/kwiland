import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineInterface {
    String file;
    RailSystem railSystem;
    Boolean running = true;

    public void setFile() {
        file = readFile();

        if (file != null) {
            Parser parser = new Parser();
            RailBuilder builder = new RailBuilder();

            ArrayList<String[]> formattedInput = parser.formatInput(file);
            ArrayList<Town> townArray = builder.setTownArray(formattedInput);
            this.railSystem = new RailSystem(townArray);
        } else {
            running = false;
        }
    }

    private String getUserInput(String prompt) {
        Scanner userInput = new Scanner(System.in);

        String userString;
        System.out.println(prompt);
//        System.out.println(userInput);
        userString = userInput.next();
        userInput.close();

        return userString;
    }

    private String[] getInputForMethod(String prompt) {
        Scanner userInput = new Scanner(System.in);

        String userSting;
        System.out.println(prompt);
        userSting = userInput.next();

        return userSting.split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    }

    public String readFile() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter text file name with extention : ");
            File file = new File(input.nextLine());

            Scanner fileText = new Scanner(file);


            while (fileText.hasNextLine()) {
                String line = fileText.nextLine();
                return line;
            }
            input.close();

        } catch (Exception ex) {
            Scanner input = new Scanner(System.in);
            System.out.println("No File Found. Enter agin? (y/n)");
            String retryValue = input.next();

            if (retryValue.equals("y")) {
                readFile();
            } else {
                input.close();
                return null;
            }

        }
        return null;
    }

    public void chooseMethod() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1-5: \n 1. Find Distance of rout. \n 2. Find number of trips with maxim stop. \n 3. Find number of trips with exact number of stops. \n 4. Find shortest distance between two points. \n 5. Find number of routes with maximum distance. \n\n 6. RETURN TO FILE INPUT");

        String method = input.next();

        String[] userInput;
        int answer;
        switch (method) {
            case "1":
                System.out.println("Enter Route with no spaces Ex. ABC");
                userInput = input.next().split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                answer = railSystem.findRouteDistance(userInput);
                System.out.println(answer);
                chooseMethod();
            case "2":
                System.out.println("Enter start and end routes, and Max number of stops Ex. AC2");
                userInput = input.next().split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                answer = railSystem.numberOfTripsWithMaxStops(userInput[0], userInput[1], Integer.parseInt(userInput[2]));
                System.out.println(answer + "\n");
                chooseMethod();
            case "3":
                System.out.println("Enter start and end routes, and Exact number of stops Ex. AC2");
                userInput = input.next().split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                answer = railSystem.numberOfTripsWithExactlyNStops(userInput[0], userInput[1], Integer.parseInt(userInput[2]));
                System.out.println(answer + "\n");
                chooseMethod();
            case "4":
                System.out.println("Enter start and end routes Ex. BC");
                userInput = input.next().split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                answer = railSystem.returnShortestDistance(userInput[0], userInput[1]);
                System.out.println(answer + "\n");
                chooseMethod();
            case "5":
                System.out.println("Enter start and end routes, and Max distance Ex. CC30");
                userInput = input.next().split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                answer = railSystem.numberOfRoutesUnderLength(userInput[0], userInput[1], Integer.parseInt(userInput[2]));
                System.out.println(answer + "\n");
                chooseMethod();
            case "6":
                break;
            default:
                System.out.println("Invalid Input");
                chooseMethod();
        }
    }
}