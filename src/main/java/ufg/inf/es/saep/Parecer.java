package saep;

public class Parecer {

    private final long status;
    private final String parecer;

    public Parecer(long status, String parecer) {
        this.status = status;
        this.parecer = parecer;
    }

    public long getStatus() {
        return status;
    }

    public String getParecer() {
        return parecer;
    }
}