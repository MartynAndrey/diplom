package data;

import lombok.Value;

@Value
public class DBConnectionInfo {
    private String url;
    private String port;
    private String db;
    private String user;
    private String password;

    public String getFullUrl() {
        return this.url + ":" + this.getPort() + "/" + this.getDb();
    }
}