package platform.codingnomads.co.springweb.resttemplate.POST.postForObject;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String created_at;
    private String updated_at;

}
