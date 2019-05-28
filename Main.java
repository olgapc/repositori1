/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videosproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author olga
 */
public class Main
{

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception
    {
        List<User> userList = new ArrayList<User>();

        Scanner sc = new Scanner(System.in);
        menu(sc, userList);

    }

    //first menu
    private static void menu(Scanner sc, List<User> userList) throws Exception
    {

        int option = 0;
        boolean isCorrect = false;

        do
        {
            try
            {

                System.out.println("Selecciona una de les opcions: "
                        + "\n 1. Crear usuari"
                        + "\n 2. Login");
                option = sc.nextInt();
                sc.nextLine();
                if (option > 0 && option < 3)
                {
                    isCorrect = true;

                } else
                {
                    throw new IOException();
                }
            } catch (IOException e)
            {
                isCorrect = false;
                System.out.println("Aquesta opció no és vàlida");
            } catch (InputMismatchException e)
            {
                isCorrect = false;
                System.out.println("Aquesta opció no és vàlida");
                sc.next();
            }
        } while (!isCorrect);

        System.out.println("Has triat l'opció: " + option);

        switch (option)
        {
            case 1:
                //Sign in
                createUser(sc, userList);
                break;
            case 2:
                //Login
                verifyUser(sc, userList);
                break;

        }

    }

    //menu for login user
    private static void menu2(Scanner sc, User user) throws Exception
    {

        int option = 0;
        boolean isCorrect = false;

        do
        {
            try
            {

                System.out.println("Selecciona una de les opcions: "
                        + "\n 1. Afegir video"
                        + "\n 2. Veure llistat videos"
                        + "\n 3. Sortir");
                option = sc.nextInt();
                sc.nextLine();
                if (option > 0 && option < 4)
                {
                    isCorrect = true;

                } else
                {
                    throw new IOException();
                }
            } catch (IOException e)
            {
                isCorrect = false;
                System.out.println("Aquesta opció no és vàlida");
            } catch (InputMismatchException e)
            {
                isCorrect = false;
                System.out.println("Aquesta opció no és vàlida");
                sc.next();
            }
        } while (!isCorrect);

        System.out.println("Has triat l'opció: " + option);

        switch (option)
        {
            case 1:
                //add video
                Video video = askVideo(sc);

                user.setVideoList(video);
                System.out.println("Video afegit correctament "
                        + "\ntítol: " + video.getTitle()
                        + "\nurl: " + video.getVideoUrl()
                        + "\netiquetes: " + video.getTags());
                menu2(sc, user);
                break;
            case 2:
                //list videos
                int i = 0;
                for (Video v : user.getVideoList())
                {
                    i++;
                    System.out.println("Video " + i
                            + "\nTítol: " + v.getTitle()
                            + "\nURL: " + v.getVideoUrl()
                            + "\ntags: " + v.getTags() + "\n");
                }
                menu2(sc, user);
                break;
            case 3:
                //exit
                System.exit(0);
                break;
        }
    }

    public static void createUser(Scanner sc, List<User> userList) throws Exception
    {
        String surname = askName(sc, "nom");
        String name = askName(sc, "cognom");
        String mail = askMail(sc, "mail", userList);
        String password = askPassword(sc, "password");
        User user = new User(surname, name, mail, password);
        userList.add(user);

        System.out.println("Usuari creat correctament amb les següents dades: "
                + "\n nom: " + user.getName()
                + "\n cognom: " + user.getSurname()
                + "\n password: " + user.getPassword()
                + "\n data creació: " + user.getRegistrationDate()
                + "\n identificació: " + user.getIdUser() + "\n");
        menu(sc, userList);
    }

    //ask and check the name
    public static String askName(Scanner sc, String nameType) throws Exception
    {
        String answer = "";
        boolean isCorrect = false;

        do
        {
            System.out.println("Diga'm el teu  " + nameType + ":");
            try
            {
                answer = sc.nextLine();
                if (answer.isEmpty())
                {
                    throw new Exception();
                }
                for (Character a : answer.toCharArray())
                {
                    if (Character.isLetter(a))
                    {
                        isCorrect = true;
                    } else
                    {
                        throw new IOException();
                    }
                }
            } catch (IOException e)
            {
                isCorrect = false;
                System.out.println("Un " + nameType + " només pot contenir lletres.");
            } catch (Exception e)
            {
                isCorrect = false;
                System.out.println("Aquest camp no pot estar buit.");
            }
        } while (!isCorrect);
        return answer;
    }

    //ask and check the password
    public static String askPassword(Scanner sc, String nameType) throws Exception
    {
        String answer = "";
        boolean isCorrect = false;

        do
        {
            System.out.println("Diga'm el teu  " + nameType + ":");
            try
            {
                answer = sc.nextLine();

                if (answer.isEmpty())
                {
                    throw new Exception();
                }

                if (answer.length() > 3 && answer.length() < 9)
                {
                    isCorrect = true;
                } else
                {
                    throw new IOException();
                }
            } catch (IOException e)
            {
                isCorrect = false;
                System.out.println("El " + nameType + " ha de tenir una longítud mínima de 4 i màxima de 8 caràcters.");

            } catch (Exception e)
            {
                isCorrect = false;
                System.out.println("Aquest camp no pot estar buit.");
            }
        } while (!isCorrect);
        return answer;
    }

    //ask and check the user to login
    public static void verifyUser(Scanner sc, List<User> userList) throws Exception
    {

        boolean found = false;
        do
        {
            String mail = askMail(sc, "mail");
            String password = askPassword(sc, "password");
            User user = userExists(userList, mail, password);
            if (user == null)
            {
                menu(sc, userList);
            } else
            {
                found = true;
                System.out.println("Hola " + user.getSurname());

                menu2(sc, user);

            }
        } while (!found);
    }

    //ask and check the mail to login
    public static String askMail(Scanner sc, String nameType) throws Exception
    {
        String answer = "";
        boolean isCorrect = false;
        do
        {
            System.out.println("Diga'm el teu  " + nameType + ":");
            try
            {
                answer = sc.nextLine();

                if (answer.isEmpty())
                {
                    throw new Exception();
                } else
                {
                    isCorrect = true;
                }
            } catch (Exception e)
            {
                isCorrect = false;
                System.out.println("Aquest camp no pot estar buit.");
            }
        } while (!isCorrect);
        return answer;
    }

    //ask and check the mail to sign in
    public static String askMail(Scanner sc, String nameType, List<User> userList) throws Exception
    {
        String answer = "";
        boolean isCorrect = false;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        do
        {
            System.out.println("Diga'm el teu  " + nameType + ":");
            try
            {
                answer = sc.nextLine();

                if (answer.isEmpty())
                {
                    throw new Exception();
                }

                Matcher mather = pattern.matcher(answer);

                if (mather.find() == true)
                {
                    isCorrect = true;

                } else
                {

                    throw new IOException("El " + nameType + " ha de tenir un format vàlid.");
                }

                if (userExists(userList, answer))
                {
                    throw new IOException("Aquest " + nameType + " ja existeix.");
                }
            } catch (IOException e)
            {
                isCorrect = false;
                System.out.println(e);

            } catch (Exception e)
            {
                isCorrect = false;
                System.out.println("Aquest camp no pot estar buit.");
            }
        } while (!isCorrect);
        return answer;

    }

    //verify if the mail is already create
    public static boolean userExists(List<User> userList, String mail)
    {
        boolean exist = false;
        for (User u : userList)
        {
            exist = u.getMail().equals(mail);
        }
        return exist;
    }

    //verify if the user who log in exists
    public static User userExists(List<User> userList, String mail, String password) throws IOException
    {
        User user = null;

        try
        {
            if (userList.size() == 0)
            {
                throw new IOException();
            }

            for (User u : userList)
            {
                if (u.getMail().equals(mail)
                        && u.getPassword().equals(password))
                {
                    user = u;
                    return user;

                } else
                {
                    throw new IOException();
                }
            }

        } catch (IOException e)
        {
            System.out.println("Usuari o password incorrectes");
        }
        return user;
    }

    //ask and check a video
    public static Video askVideo(Scanner sc)
    {
        System.out.println("Introdueix el títol del vídeo");
        String title = sc.nextLine();
        System.out.println("Introdueix la URL del vídeo");
        String videoUrl = sc.nextLine();
        System.out.println("Introdueix les etiquetes separades per comes");
        String tags = sc.nextLine();
        String[] tagsElements;
        tagsElements = tags.split(",");

        ArrayList<String> tagList = new ArrayList<>();
        for (String tagsElement : tagsElements)
        {
            tagList.add(tagsElement);
        }

        Video video = new Video(videoUrl, title, tagList);

        return video;

    }

}
