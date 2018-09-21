package tv.ui;

import java.util.ArrayList;
import java.util.List;

import tv.business.Show;
import tv.business.ShowDB;
import tv.util.Console;

public class TVShowApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the TV Show DB App");
		System.out.println();
		
		ShowDB showDB = new ShowDB();
		String command = "";
		while (!command.equalsIgnoreCase("3")) {
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
			else if (!command.equals("3")) {
				System.out.println("Invalid command. Try again.");
			}
		}
		System.out.println("Bye");

	}
	private static void displayMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("COMMAND MENU \n");
		sb.append("1- List TV Shows \n");
		sb.append("2- List TV Shows by Genre or Length \n");
		sb.append("3- Exit Program \n");
		System.out.println(sb);
	}
}
