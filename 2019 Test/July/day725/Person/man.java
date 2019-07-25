package Person;

public class man implements person{
    private String name;
    public man(){

    }
    public String read() {
        return this.name+"wudi";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
