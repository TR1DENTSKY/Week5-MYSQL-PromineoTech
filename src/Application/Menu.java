package Application;

import DAO.AutobotsDAO;
import DAO.DecepticonsDAO;
import DAO.TransformersDAO;
import Entity.Transformers;

import javax.xml.transform.Transformer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private TransformersDAO TransformersDao = new TransformersDAO();
    private DecepticonsDAO DeceptionsDao = new DecepticonsDAO();
    private AutobotsDAO AutobotsDao = new AutobotsDAO();
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = Arrays.asList(
            "Display Transformers",
            "Display a Transformer",
            "Create a Transformer",
            "Delete a Transformer",
            "Create a Decepticon",
            "Delete a Decepticon",
            "Create a Autobot",
            "Delete a Autobot");

    public void start () {
        String selection = "";

        do {
            printMenu();
            selection = scanner.nextLine();

            try {
                if (selection.equals("1")) {
                    displayTransformers();
                } else if (selection.equals("2")) {
                    displayTransformers();
                } else if (selection.equals("3")) {
                    createTransformer();
                } else if (selection.equals("4")) {
                    deleteTransformer();
                } else if (selection.equals("5")) {
                    createDecepticon();
                } else if (selection.equals("6")) {
                    deleteDecepticon();
                } else if (selection.equals("7")) {
                    createAutobot();
                } else if (selection.equals("8")) {
                    deleteAutobot();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }

            System.out.println("Press ENTER to continue...");
            scanner.nextLine();
        } while (!selection.equals("-1"));
    }

    private void printMenu() {
        System.out.println("Select an Option: \n--------------------------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + ") " + options.get(i));
        }
    }

    private void displayTransformers() throws SQLException {
        List<Transformers> Transformers = TransformersDao.getTransformers();
        for (Entity.Transformers Transformer : Transformers) {
            System.out.println(Transformer.gettransformersId() + ": " + Transformer.getName());
        }
    }

    private void displayTransformer() {
        System.out.println("Enter Transformer ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Transformer Transformer = TransformersDAO.getTransformersId);
        System.out.println(Transformer.getTransformersId() + ": " Transformer.getName());
        for (Deceptions Deceptions : Transformer.getDeceptions()) {
            System.out.println("\tDeceptionsId: " + Deceptions.getDeceptionsId() + " - Name: " + Deceptions.getFirstName() + " " + Deceptions.getLastName());
        }
    }

    private void createTransformer() throws SQLException {
        System.out.print("Enter new Transformer name:");
        String TransformerName = scanner.nextLine();
        TransformersDao.createNewTransformer(TransformerName);
    }

    private void deleteTransformer() throws SQLException {
        System.out.print("Enter Transformer id to delete:");
        int id = Integer.parseInt(scanner.nextLine());
        TransformersDao.deleteTransformerById(id);
    }
    private void createDeceptions() throws SQLException {
        System.out.println("Enter first name of new Deceptions");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of new Deceptions");
        String lastName = scanner.nextLine();
        System.out.println("Enter Transformer id of new Deceptions");
        int TransformerId  = Integer.parseInt(scanner.nextLine());
        DeceptionsDao.createNewDeceptions(firstName, lastName, TransformerId);
    }

    private void createAutobots() throws SQLException {
        System.out.println("Enter first name of new Autobots");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of new Autobots");
        String lastName = scanner.nextLine();
        System.out.println("Enter Transformer ID of new Autobots");
        int TransformerId  = Integer.parseInt(scanner.nextLine());
        AutobotsDao.createNewAutobots(firstName, lastName, TransformerId);
    }

    private void deleteDeceptions() throws SQLException {
        System.out.println("Type Deceptions to delete");
        int TransformerId  = Integer.parseInt(scanner.nextLine());
        DeceptionsDao.deleteDeceptionsById(id);
    }

    private void deleteAutobots() throws SQLException {
        System.out.println("Type Autobots to delete");
        int TransformerId  = Integer.parseInt(scanner.nextLine());
        AutobotsDao.deleteAutobotsById(id);
    }
}
