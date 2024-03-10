package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserRepository {
    public  static List<User> getAllUser(){
          List<User> users = new ArrayList<>();
          RepositoryLoader.loaderProperties();
          // get all user form database
         String sql ="SELECT  * FROM users";
          try(
                  // connect to database
                  Connection connection = DriverManager.getConnection(
                          RepositoryLoader.properties.getProperty("database_url"),
                          RepositoryLoader.properties.getProperty("database_username"),
                          RepositoryLoader.properties.getProperty("database_password")
                  );
                  Statement statement = connection.createStatement();
                  ResultSet resultSet = statement.executeQuery(sql);
                  ){

              //
              while(resultSet.next()){
                  users.add(
                          new User(
                                  resultSet.getInt("user_id"),
                                  resultSet.getString("user_uuid"),
                                  resultSet.getString("user_name"),
                                  resultSet.getString("user_email"),
                                  resultSet.getString("user_password"),
                                  resultSet.getBoolean("is_deleted"),
                                  resultSet.getBoolean("is_verified")
                          )
                  );
              }
          }catch (Exception e){
              System.out.println(e.getMessage());
          }
      return  users;
    }
    // User get from model User
   public static User   searchAllUserByID(Integer id ){
        String sqlSearcyByid = "SELECT  * FROM  users WHERE  user_id = ?";
        try(
                Connection connection = DriverManager.getConnection(
                        RepositoryLoader.properties.getProperty("database_url"),
                        RepositoryLoader.properties.getProperty("database_username"),
                        RepositoryLoader.properties.getProperty("database_password")
                );
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery(sqlSearcyByid);
                PreparedStatement preparedStatement = connection.prepareStatement(sqlSearcyByid);
        ){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet =  preparedStatement.executeQuery()){
                while (resultSet.next()){
                    return new User(
                                    resultSet.getInt("user_id"),
                                    resultSet.getString("user_uuid"),
                                    resultSet.getString("user_name"),
                                    resultSet.getString("user_name"),
                                    resultSet.getString("user_password"),
                                    resultSet.getBoolean("is_deleted"),
                                    resultSet.getBoolean("is_verified")

                    );
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
   }



}
