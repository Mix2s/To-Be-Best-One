package bite.note5;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Cloneable, Serializable {
    private  int age;
    private String name;
    private Teacher teacher;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
