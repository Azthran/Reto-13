public class Equipo {

    private String ci;
    private String desc;
    // cantidad de equipos
    private int ct;
    //costo unitario equipo
    private long mu;
    // dia
    private short dd;
    // mes
    private short mm;
    //ano
    private int aaaa;
    // numero de factura
    private String nf;

    public Equipo() {
    }

    public Equipo(String ci, String desc,
                  int ct,
                  long mu,
                  short dd,
                  short mm,
                  int aaaa,
                  String nf) {

        this.ci = ci;
        this.desc = desc;
        this.ct = ct;
        this.mu = mu;
        this.dd = dd;
        this.mm = mm;
        this.aaaa = aaaa;
        this.nf = nf;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCt() {
        return ct;
    }

    public void setCt(int ct) {
        this.ct = ct;
    }

    public long getMu() {
        return mu;
    }

    public void setMu(long mu) {
        this.mu = mu;
    }

    public short getDd() {
        return dd;
    }

    public void setDd(short dd) {
        this.dd = dd;
    }

    public short getMm() {
        return mm;
    }

    public void setMm(short mm) {
        this.mm = mm;
    }

    public int getAaaa() {
        return aaaa;
    }

    public void setAaaa(int aaaa) {
        this.aaaa = aaaa;
    }

    public String getNf() {
        return nf;
    }

    public void setNf(String nf) {
        this.nf = nf;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "ci='" + ci + '\'' +
                ", desc='" + desc + '\'' +
                ", ct=" + ct +
                ", mu=" + mu +
                ", dd=" + dd +
                ", mm=" + mm +
                ", aaaa=" + aaaa +
                ", nf='" + nf + '\'' +
                '}';
    }
}
