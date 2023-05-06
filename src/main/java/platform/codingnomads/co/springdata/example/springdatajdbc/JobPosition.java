package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class JobPosition {

    private long id;
    private String positionTitle;
    private String positionDepartment;

    public JobPosition(long id, String positionTitle, String positionDepartment) {
        this.id = id;
        this.positionTitle = positionTitle;
        this.positionDepartment = positionDepartment;
    }
}
