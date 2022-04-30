import java.util.Scanner;
import java.util.List;

public class View{
    BMIAnalyser analyser = new BMIAnalyser();
    
    View(BMIAnalyser a){
        analyser = a;
    }
    void commandLoop(){
        while(true){
        System.out.println("Press 0 to display the menu");
        System.out.println("Press 1 to display the record for a specified person");
        System.out.println("Press 2 to display the records for all persons with BMI values within a specified range");
        System.out.println("Press 3 to display the display records for all persons");
        System.out.println("Press 4 to display the display the minimum, maximum and average BMIs");
        System.out.println("Press 9 to exit the application");
        int command = new Scanner(System.in).nextInt();
        switch(command){
            case 0:
                System.out.println(help());
                break;
            case 1:
                System.out.println("Enter name of person");
                String person = new Scanner(System.in).next();
                BMIRecord record = analyser.find(person);
                System.out.println(record==null?"Not found":record);
                break;
            case 2:
                System.out.println("Enter minimum bmi");
                double min = new Scanner(System.in).nextDouble();
                System.out.println("Enter maximum bmi");
                double max = new Scanner(System.in).nextDouble();
                List<BMIRecord> list = analyser.find(min, max);
                System.out.println(list);
                break;
            case 3:
                for(BMIRecord obj : analyser.getData())System.out.println(obj);
                break;
            case 4:
                System.out.println("Minimum: "+analyser.lowestBMI()+"\nMaximum: "+analyser.highestBMI()+"\nAverage: "+analyser.averageBMI());
                break;
            case 9:
                System.out.println("Thanks for trying");
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a valid number");
                break;
        }
        }
    }
    
    private String help() {
        return 
            "The following commands are recognised\n"+
            "\tDisplay this message                                   > 0\n"+
            "\tDisplay a specific subject record:                     > 1 subjectID\n"+
            "\tDisplay records for all subject records within a range > 2 bmi1 bmi2\n"+
            "\tDisplay all subject records                            > 3\n"+
            "\tDisplay statistics (minimum, maximum and average marks)> 4\n"+
            "\tExit the application                                   > 9" ;
    }
}