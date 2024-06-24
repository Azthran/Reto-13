import java.util.List;

public class Profesor {

    String ci;
    long totalEquipos;
    long montoTotal;

    public Profesor(String ci, Long totalEquipos, Long montoTotal) {
        this.ci = ci;
        this.totalEquipos = totalEquipos;
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +
                "\n" +
                "Profesor{" +
                "ci='" + ci + '\'' +
                ", totalEquipos=" + totalEquipos +
                ", montoTotal=" + montoTotal +
                '}' +
                "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}
