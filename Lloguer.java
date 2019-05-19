public class Lloguer {
    private String data;
    private int dies;

    public Lloguer(String data, int dies) {
        this.data = data;
        this.dies = dies;
    }

    public String getData() { return data; }

    public int getDies() { return dies; }

    public void setData(String data) { this.data = data; }

    public void setDies(int dies) { this.dies = dies; }
}
