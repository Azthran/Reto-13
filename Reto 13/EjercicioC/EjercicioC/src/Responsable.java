public class Responsable {

    String ci;
    long totalEquipos;

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public long getTotalEquipos() {
        return totalEquipos;
    }

    public void setTotalEquipos(long totalEquipos) {
        this.totalEquipos = totalEquipos;
    }

    public long getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(long montoTotal) {
        this.montoTotal = montoTotal;
    }

    long montoTotal;

    public Responsable(String ci, Long totalEquipos, Long montoTotal) {
        this.ci = ci;
        this.totalEquipos = totalEquipos;
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return  "~" +
                "\n" +
                "Responsable:{" +
                "ci='" + ci + '\'' +
                ", totalEquipos=" + totalEquipos +
                ", montoTotal=" + montoTotal +
                '}' +
                "\n" +
                "~";
    }
}
