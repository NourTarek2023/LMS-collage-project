import java.util.*;

public class Main {

    static ArrayList<Books> store = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    static Scanner sc1 = new Scanner(System.in);



    static boolean administration = false ;
    static int input  = 0;


    public static void displayBooks(){
        if (store.isEmpty())
            System.out.println("Store is Empty Please Enter some Books !");
        else
            System.out.println(store);
    }

    public static void registration (){
        Scanner sc6 = new Scanner(System.in);

        System.out.println("Enter your  username : ");
        String username = sc6.nextLine();
        System.out.println("Enter your password : ");
        String password = sc6.nextLine();

        User user = new User(username, password);
        users.add(user);
        System.out.println("Successfully registered");

    }

    public static boolean logIn (){
        Scanner sc5 = new Scanner(System.in);

        boolean found = false ;
        System.out.println("Enter username : ");
        String username = sc5.nextLine();
        System.out.println("Enter password : ");
        String password = sc5.nextLine();

        for (int i = 0; i < users.size(); i++){
            if(users.get(i).getPassword().equals(password) && users.get(i).getUsername().equals(username)){
                if(i == 0){
                    administration = true ;
                    System.out.println("welcome Administrator !");
                    found = true ;
                    break ;
                }
                else
                {
                    System.out.println("welcome "+users.get(i).getUsername());
                    found = true ;
                    break ;
                }
            }
        }

        return found;
    }


    public static void adminPage (){
        do {
            System.out.println("1- Show Books\n2- Add a Book \n3- Delete a book \n4- Edit a Book\n5- Search\n6- Exit");
            input = sc1.nextInt();
            switch (input){
                case 1:
                    displayBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    editBook();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    System.out.println("Successful Exit");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
        while (input!=6);
    }


    public static void userPage (){
        do {
            System.out.println(" 1- Show Books\n2- Search\n3- Exit");
            input = sc1.nextInt();
            switch (input){
                case 1:
                    displayBooks();
                    break;

                case 2:
                    search();
                    break;
                case 3:
                    System.out.println("Successful Exit");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
        while (input!=3);
    }


    public static void homePage (){
        if (administration){
            adminPage();
        }
        else{
            userPage();
        }
    }



    public static void addBook(){
        Scanner sc3 = new Scanner(System.in);

        System.out.println("Enter Name Of The Book :");
        String name = sc3.nextLine();
        System.out.println("Enter Type Of The Book :");
        String type = sc3.nextLine();
        System.out.println("Enter Author Of The Book :");
        String author = sc3.nextLine();
        System.out.println("About Of The Book :");
        String about = sc3.nextLine();
        Books b = new Books(name,type,author,about);
        store.add(b);
    }

    public static void deleteBook(){
        Scanner sc2 = new Scanner(System.in);

        int index = -1;
        System.out.println("Enter Name Of the Book : ");
        String name = sc2.nextLine().toLowerCase();
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getBookTitle().toLowerCase().equals(name) ) {
                index = i;
                break;
            }
        }
        if (index == -1)
            System.out.println("Sorry Book Not  Found!");
        else{
            store.remove(index);
            System.out.println("Successfully Deleted");
        }
    }


    public static void editBook() {

        Scanner sc4 = new Scanner(System.in);
        int index = -1, x;

        System.out.println("Enter Name Of the Book to Edit: ");
        String name = sc4.nextLine().toLowerCase();

        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getBookTitle().toLowerCase().equals(name) ) {
                index = i;
                break;
            }
        }

        if (index==-1)
            System.out.println("Sorry Book Not  Found!");

        else {
            System.out.println("1-Edit Title Of The Book \n2-Edit Type Of The Book \n3-Edit Author Of The Book" +
                    "\n4-Edit the synopsis of the book ");
            x = sc4.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Enter new Title :");
                    String title = sc4.nextLine();
                    store.get(index).setBookTitle(title);
                    break;
                case 2:
                    System.out.println("Enter new Type :");
                    String type = sc4.nextLine();
                    store.get(index).setBookType(type);
                    break;
                case 3:
                    System.out.println("Enter new Author :");
                    String author = sc4.nextLine();
                    store.get(index).setAuthor(author);
                    break;
                case 4:
                    System.out.println("Enter new Synopsis :");
                    String about = sc4.nextLine();
                    store.get(index).setAboutTheBook(about);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }

    }

    public static boolean search(){
        boolean  found = false;
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter Book To Search:");
        String name = sc3.nextLine().toLowerCase();
        for (int i=0; i<store.size() ; i++)
        {
            if(store.get(i).getBookTitle().toLowerCase().equals(name)) {
                found = true;
                System.out.println(store.get(i));
            }
        }
        if(!found)
            System.out.println("Sorry book not found !");
        return found;
    }











    public static void main(String[] args) {
        User admin = new User("admin", "admin");
        User user1 = new User("halawa", "123");

        users.add(admin);
        users.add(user1);

        Books b1 = new Books("Atomic Habits","Psychology Books"," James Clear","An Easy & Proven Way to Build Good Habits & Break Bad Ones");
        Books b2 = new Books("Surrounded by Psychopaths","Psychology Books","Thomas Erikson"," How to Protect Yourself from Being Manipulated and Exploited in Business (and in Life)");
        store.add(b1);
        store.add(b2);


        do {
            System.out.println("1- Registration\n2- login\n0- Exit");
            input = sc1.nextInt();

            switch(input) {
                case 1:
                    registration();
                    break;
                case 2:
                    if (logIn())
                        homePage();
                    else
                        System.out.println(" Invalid username or password !");
                    break;
                case 0:
                    System.out.println("Successfully Exited");
                    break;
                default:
                    System.out.println("Invalid input");

            }
        }while(input != 0);







    }
}