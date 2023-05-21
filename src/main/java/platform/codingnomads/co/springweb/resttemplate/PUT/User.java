package platform.codingnomads.co.springweb.resttemplate.PUT;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String created_at;
    private String updated_at;


}
