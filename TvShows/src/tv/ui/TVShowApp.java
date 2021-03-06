package tv.ui;

import java.util.ArrayList;
import java.util.List;

import tv.business.Show;
import tv.business.ShowDB;
import tv.util.Console;

public class TVShowApp {
	private static ShowDB showDB = new ShowDB();
	public static void main(String[] args) {
		System.out.println("Welcome to the TV Show DB App\n");
				
		ShowDB showDB = new ShowDB();
		String command = "";
		while (!command.equalsIgnoreCase("6")) {
			displayMenu();
			command = Console.getString("Enter command: ");
			System.out.println();
			if (command.equals("1")) {
				List<Show> shows = showDB.getAll();
				for(Show s : shows) {
					System.out.println(s);
				}
			}
			else if (command.equals("2")) {
				// search for a show
				String criteria = Console.getString("Search by (g)enre or (l)ength? ","g","l");
				System.out.println();
				List<Show> shows = new ArrayList<>();
				if (criteria.equalsIgnoreCase("g")) {
					// search by show genre
					String genre = Console.getString("What type of Drama? Comedy, Sci-Fi, Action, Drama? ");
					shows = showDB.get(genre);
				}
				else if (criteria.equalsIgnoreCase("l")) {
					//search by show length
					int length = Console.getInt("Enter show length? 30, 60, 90? ");
					shows = showDB.get(length);
				}
				System.out.println("Result of search: ");
				for (Show s : shows) {
					System.out.println(s);
				}
				System.out.println();
			}
			else if (command.equals("3")) {
				//add show
				String name = Console.getString("Enter TV Show name: ");
		        String rating = Console.getString("Enter show rating: ");
		        int length = Console.getInt("Enter show length: ");
		        String genre = Console.getString("Enter show genre: ");
		        String network = Console.getString("Enter show network: ");
		        		
		        
		        Show show = new Show(name, rating, length, genre, network);
		        

		        boolean success = showDB.add(show);
		        if (success) {
		            System.out.println(name
		                    + " has been added to the database.\n");
		        } else {
		            System.out.println("Error! Unable to add show.\n");
		        }
		    }
			
			
			else if (command.equals("5")) {
				// delete show
				String name = Console.getString("Enter name of show to delete: ");
		        Show show = (Show) showDB.get(name);
		        if (showDB.delete(show)) {
		        	System.out.println(show.getName() + " has been deleted from the database.\n");
		        }		        
		        else {
		            System.out.println("Error! Unable to delete show.\n");
		        }
		        System.out.println();
		    }
			else if (!command.equals("6")) {
				System.out.println("Invalid command. Try again.");
			}
		}
		System.out.println("Bye");

	}
	
	private static void displayMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("COMMAND MENU \n");
		sb.append("1- List TV Shows \n");
		sb.append("2- View TV Shows by Genre or Length \n");
		sb.append("3- Add TV Show \n");
	//	sb.append("4- Edit TV Show \n");
		sb.append("5- Delete TV Show \n");
		sb.append("6- Exit Program \n");
		System.out.println(sb);
	}
}
