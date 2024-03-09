
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("1.Initialize the Parking Lot");
            System.out.println("2.Add Vehicle");
            System.out.println("3.Remove Vehicle");
            System.out.println("4.Check Availability");
            System.out.println("0.Exit!");
            System.out.print("Choose below option:- ");

            while(true) {
                try {
                    choice = sc.nextInt();
                    System.out.println();
                    break;
                }catch(InputMismatchException ex) {
                    System.out.print("Invalid Input. Please Inter Integer Value :- ");
                    sc.nextLine();
                }
            }

            switch(choice) {
                case 1:
                    initializeVehicle(sc);

                    break;
                case 2:
                    addVehicle(sc);
                    break;
                case 3:
                    removeVehicle(sc);
                    break;
                case 4:
                    checkAvailability(sc);
                    break;

                case 0:
                    System.out.println("Thanks you,visit Again ! ");
                    break;
                default :
                    System.out.println("Pls Choose Correct Selection");
            }
        }while(choice != 0);
    }

    static ParkingLot parkingLot =new ParkingLot(2, 2);

    private static void checkAvailability(Scanner sc) {
        ParkingLot parkingLot = new ParkingLot(1, 5);
        System.out.print("Enter floor number : ");
        int floorNo = sc.nextInt();
        System.out.print("Enter Vehicle Type : ");
        String vehicleType = sc.next();

        parkingLot.checkAvailability(floorNo, vehicleType);

    }

    private static void removeVehicle(Scanner sc) {

        ParkingLot parkingLot = new ParkingLot(1, 5);

        System.out.print("Enter registration Number : ");
        String registrationNo = sc.next();
        parkingLot.removeVehicle(registrationNo);

    }

    private static void addVehicle(Scanner sc) {

        ParkingLot parkingLot = new ParkingLot(1, 5);

        System.out.print("Enter Vehicle Types : ");
        String vehicleType = sc.next();
        System.out.print("Enter registration Number : ");
        String registrationNo = sc.next();
        System.out.print("Enter Vehicle color : ");
        String color = sc.next();

        parkingLot.addVehicle(vehicleType, registrationNo, color);
    }

    private static void initializeVehicle(Scanner sc) {

        System.out.print("Enter number of floor : ");
        int floorNo = sc.nextInt();
        System.out.print("Enter capacity : ");
        int capacityForFloor = sc.nextInt();

        try {
            parkingLot.init(floorNo, capacityForFloor);
        } catch (Exception e) {
            System.out.println("error :-"+e);
        }

    }

}
