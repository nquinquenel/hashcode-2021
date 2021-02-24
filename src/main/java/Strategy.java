import lombok.Data;

@Data
public abstract class Strategy {

    protected final String name;

    public Strategy(final String name) {
        this.name = name;
    }

}
