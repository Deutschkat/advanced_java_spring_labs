package platform.codingnomads.co.springweb.resttemplate.POST.postForObject;

import lombok.Data;

@Data
public class ResponseObjectUser {
    User data;
    Error error;
    String status;
}
