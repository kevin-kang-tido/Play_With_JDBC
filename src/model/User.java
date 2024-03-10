package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// use using lambok
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class User {
    private  Integer userId;
    private  String userUUID;
    private  String userName;
    private  String userEmail;
    private  String userPassword;
    private Boolean isDeleted ;
    private Boolean isVerified;
}
