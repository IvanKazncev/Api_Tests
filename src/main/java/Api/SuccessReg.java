package Api;

public class SuccessReg {
    private Integer id;
    private String token;
    private Integer status;

    public SuccessReg()
    {
        super();
    }
    public SuccessReg(Integer id, String token) {
        this.id = id;
        this.token = token;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public Integer status() {
        return status;
    }
}

