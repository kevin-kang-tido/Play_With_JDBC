package view;

import controller.UserController;
import model.User;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public  class UserView {
    public static UserController userController = new UserController();

    public static void uiForUser() {
        System.out.println("=".repeat(50));
        System.out.println("=".repeat(15) + ": Menu To Play :" + "=".repeat(15));
        System.out.println("=".repeat(50));
        System.out.println("1 Read All User");
        System.out.println("2 Search User BY Id ");
        System.out.println("3 Create User ");
        System.out.println("4 Update User ");
        System.out.println("5 Delete User ");
        System.out.println("=".repeat(50));
        System.out.println("Please choose your Option to play with : ");
        Integer optionToPlay = new Scanner(System.in).nextInt();

        try {
            switch (optionToPlay) {
                // ready all user in database
                case 1 -> {
                    readAllUser();


                }
                // search user by id
                case 2 -> {
                    searchUserById();

                }
                // create user
                case 3 -> {

                }
                // update all user
                case 4 -> {

                }
                // delete user
                case 5 -> {

                }
                case 6 -> exit(0);


                default -> System.out.println("Please Open your eye and Choose again!!!!!!");

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

}
    // ui for option 1
    public static void readAllUser(){
        try {
            Table table = new Table(7, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
            CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);

            List<User> users = userController.getAllUser();

            table.addCell("  USER ID  ");
            table.addCell("  USER UUID  ");
            table.addCell("     USER NAME     ");
            table.addCell("     USER EMAIL     ");
            table.addCell("     USER PASSWORD     ");
            table.addCell("     USER IS DELETED     ");
            table.addCell("     USER IS VERIFY     ");
            for (User user : users) {
                table.addCell(String.valueOf(user.getUserId()), cellStyle);
                table.addCell(user.getUserUUID(), cellStyle);
                table.addCell(user.getUserName(), cellStyle);
                table.addCell(user.getUserEmail(), cellStyle);
                table.addCell(user.getUserPassword(), cellStyle);
                table.addCell(String.valueOf(user.getIsDeleted()), cellStyle);
                table.addCell(String.valueOf(user.getIsVerified()), cellStyle);
            }
            System.out.println(table.render());
        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }

    // ui for option 2 search all user by id
    public  static void searchUserById(){
        try{
            System.out.print(">>>>> Enter User ID: ");
            Integer searchID = new Scanner(System.in).nextInt();
            Table table = new Table(7, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
            CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);

            List<User> users = Collections.singletonList(userController.searchAllUserById(searchID));

            table.addCell("  USER ID  ");
            table.addCell("  USER UUID  ");
            table.addCell("     USER NAME     ");
            table.addCell("     USER EMAIL     ");
            table.addCell("     USER PASSWORD     ");
            table.addCell("     USER IS DELETED     ");
            table.addCell("     USER IS VERIFY     ");
            for (User user : users) {
                table.addCell(String.valueOf(user.getUserId()), cellStyle);
                table.addCell(user.getUserUUID(), cellStyle);
                table.addCell(user.getUserName(), cellStyle);
                table.addCell(user.getUserEmail(), cellStyle);
                table.addCell(user.getUserPassword(), cellStyle);
                table.addCell(String.valueOf(user.getIsDeleted()), cellStyle);
                table.addCell(String.valueOf(user.getIsVerified()), cellStyle);
            }
            System.out.println(table.render());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    }

