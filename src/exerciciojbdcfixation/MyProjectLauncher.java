package exerciciojbdcfixation;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentStoreDao;
import model.dao.MallDao;
import model.dao.RentDao;
import model.entities.DepartmentStore;
import model.entities.Mall;
import model.entities.Rent;

public class MyProjectLauncher {
	static Date createDate(Scanner sc) {
		System.out.println("Please type it the year in the Four digit format");
		int year = sc.nextInt();
		System.out.println("Please type it the month in two digit format");
		int month = sc.nextInt();
		System.out.println("Please type it the day in two digit format");
		int day = sc.nextInt();
		Map <Integer,Integer> mapMonths = Map.ofEntries(Map.entry(1,Calendar.JANUARY), 
				Map.entry(2,Calendar.FEBRUARY),
				Map.entry(3,Calendar.MARCH),
				Map.entry(4,Calendar.APRIL),
				Map.entry(5,Calendar.MAY),
				Map.entry(6,Calendar.JUNE),
				Map.entry(7,Calendar.JULY),
				Map.entry(8,Calendar.AUGUST),
				Map.entry(9,Calendar.SEPTEMBER),
				Map.entry(10,Calendar.OCTOBER),
				Map.entry(11,Calendar.NOVEMBER),
				Map.entry(12,Calendar.DECEMBER));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH, mapMonths.get(month));
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}
	static Rent createRent(Scanner sc) {
		System.out.println("Please type it the current mounth of the Rent");
		sc.nextLine();
		Date currentMonth = createDate(sc);
		System.out.println("Please type it the id of the Mall");
		int idMall = sc.nextInt();
		System.out.println("Please type it the id of the DepartmentStore");
		int idDepartmentStore = sc.nextInt();
		System.out.println("Please type it the current Rent");
		Double currentRent = sc.nextDouble();
		return new Rent(0, currentMonth, new Mall(idMall), new DepartmentStore(idDepartmentStore),currentRent,0.00,false);
	}
	static Mall createMall(Scanner sc) {
		System.out.println("Please type it the name of the Mall");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Please type it the city name of the Mall");
		String cityName = sc.nextLine();
		System.out.println("Please type it the state of country of the Mall");
		String stateOfCountry = sc.nextLine();
		System.out.println("Please type it the country of the Mall");
		String country = sc.nextLine();
		return new Mall(0,name,cityName,stateOfCountry,country);
	}
	static DepartmentStore createDepartmentStore(Scanner sc) {
		System.out.println("Please type it cnpj of department store");
		sc.nextLine();
		String cnpj = sc.nextLine();
		System.out.println("Please type it the name of the department store");
		String name = sc.nextLine();
		System.out.println("Please type it the email of the department store");
		String email = sc.nextLine();
		System.out.println("Please type it the creation date of department store");
		Date creationDate = createDate(sc);
		System.out.println("Please type it the started date of department store on the mall");
		Date startedDate = createDate(sc);
		System.out.println("Please type it the current area cover by the department store");
		int currentArea = sc.nextInt();
		System.out.println("Please type it the mall id");
		int mallId = sc.nextInt();
		return new DepartmentStore(0,cnpj,name,email,creationDate,startedDate,currentArea,new Mall(mallId));
	}
	
	static void insertMall(MallDao mall,Scanner sc) {
		mall.insertMall(createMall(sc));
	}
	
	static void insertRent(RentDao rent,Scanner sc) {
		rent.insertRent(createRent(sc));
	}
	
	static void insertDepartmentStore(DepartmentStoreDao dep,Scanner sc) {
		dep.insertDepartmentStore(createDepartmentStore(sc));
	}
	static void insertingOnTable(MallDao mall,RentDao rent,DepartmentStoreDao dep,Scanner sc) {
		System.out.println("Type 1 for Inserting on Department Store");
		System.out.println("Type 2 for Inserting on Rent");
		System.out.println("Type 3 for Inserting on mall");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			insertDepartmentStore(dep,sc);
			break;
		case 2:
			insertRent(rent,sc);
			break;
		case 3:
			insertMall(mall,sc);
			break;
		default:
			break;
	}
		
	}
	static void readTable() {
		
	}
	static void deleteRecord() {
		
	}
	static void updateRecord() {
		
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		RentDao rentDao = DaoFactory.createRentDao();
		MallDao mallDao = DaoFactory.createMallDao();
		DepartmentStoreDao departmentStoreDao = DaoFactory.createDepartmentStoreDao();
		boolean cond = true;
		while(cond){
			Scanner sc = new Scanner(System.in);
			System.out.println("Type 1 for Inserting on table");
			System.out.println("Type 2 for Read table");
			System.out.println("Type 3 for Delete column");
			System.out.println("Type 4 for Update column");
			int option = sc.nextInt();
			switch (option) {
				case 1:
					insertingOnTable(mallDao,rentDao,departmentStoreDao,sc);
					break;
				case 2:
					readTable();
					break;
				case 3:
					deleteRecord();
					break;
				default:
					cond = false; 
					break;
			}
			
		}
		

		
		
	}

}
