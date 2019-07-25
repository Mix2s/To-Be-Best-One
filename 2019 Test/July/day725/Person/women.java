package Person;

public class women implements person{
    private String zz;
    private man wudihui;
    public women(){}

    public String read() {
        return "dance";
    }
    public void dance(String name){
        System.out.println(this.zz+"chance");
    }

    public String getZz() {
        return zz;
    }

    public void setZz(String zz) {
        this.zz = zz;
    }

    public man getWudihui() {
        return wudihui;
    }

    public void setWudihui(man wudihui) {
        this.wudihui = wudihui;
    }
}
