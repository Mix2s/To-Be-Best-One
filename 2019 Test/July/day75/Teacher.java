package bite.note5;

import lombok.Data;

import java.io.Serializable;

@Data
public class Teacher implements Serializable {
    private String name;
    private String direction;

}
