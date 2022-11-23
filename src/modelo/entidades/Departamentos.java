package modelo.entidades;

import java.io.Serializable;
import java.util.Objects;

public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String Setor;

    public Departamentos() {
    }

    public Departamentos(Integer id, String setor) {
        this.id = id;
        Setor = setor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String setor) {
        Setor = setor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamentos that = (Departamentos) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Departamentos{" +
                "id=" + id +
                ", Setor='" + Setor + '\'' +
                '}';
    }
}
