import java.util.Scanner;
import java.util.LinkedList;
import java.util.Comparator;
import java.io.FileWriter;

public class AutomobileData {	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Automobile> AutomobileList = new LinkedList<>();
		
		System.out.println("Enter Automobile data and type 'exit' when finished.");
		while(true) {
			System.out.println("Enter the make of the Automobile : ");
			String make = scanner.nextLine();
			if(make.equalsIgnoreCase("exit")) {
				break;
			}
			System.out.println("Enter the model of the Automobile : ");
			String model = scanner.nextLine();
			double milesPerGallon;
			while(true) {
				System.out.println("Enter the miles per gallon of the Automobile : ");
				String inputMiles = scanner.nextLine();
				try {
					milesPerGallon = Double.parseDouble(inputMiles);
					break;
				} catch(Exception e) {
					System.out.println("Invalid input. Please enter valid miles.");
				}				
			}
			Automobile newAutomobile = new Automobile(make, model, milesPerGallon);
			AutomobileList.add(newAutomobile);
		}
		scanner.close();
		
		SortByMPG(AutomobileList, new CompareByMilesPerGallon());
		System.out.println("\nAutomobile sorted by Miles Per Gallon: ");
		for(int i=0; i<AutomobileList.size(); i++) {
			System.out.println(AutomobileList.get(i));
		}
		FileWriter(AutomobileList);
	}
	public static void SortByMPG(LinkedList<Automobile> automobile, Comparator<Automobile> comparator) {
		for(int i=0; i<automobile.size()-1; i++) {
			int index = i;
			for(int j= i+1; j<automobile.size(); j++ ) {
				if(comparator.compare(automobile.get(j), automobile.get(index)) < 0) {
					index = j;
				}
			}
			Automobile data = automobile.get(index);
			automobile.set(index, automobile.get(i));
			automobile.set(i, data);
		}
	}
	public static void FileWriter(LinkedList<Automobile> automobiles) {
		try {			
			FileWriter fileWriter = new FileWriter("C:\\Temp\\Automobiles.txt");
			for(int i=0; i<automobiles.size();i++) { 
				String automobileDetail =  automobiles.get(i).getMake()+"   "
						+ automobiles.get(i).getModel()+"   "+automobiles.get(i).getMilesPerGallon(); 
				fileWriter.write(automobileDetail + "\n"); 
			}	
			fileWriter.close();
			System.out.println("Sucessfully file saved.");
		}catch(Exception e) {
			System.out.println("File couldnot be saved.");
		}
	}
}
