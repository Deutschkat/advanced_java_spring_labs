package platform.codingnomads.co.springweb.resttemplate.PUT.models;

import lombok.Data;
import platform.codingnomads.co.springweb.resttemplate.PUT.User;

@Data
public class ResponseObjectUser {

    User data;
    Error error;
    String status;

}
