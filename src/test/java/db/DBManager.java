package db;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import data.DBConnectionInfo;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    private String dbUrl = System.getProperty("db.url");
    private String dbPort = System.getProperty("db.port");
    private String dbName = System.getProperty("db.name");
    private String dbUser = System.getProperty("db.user");
    private String dbPassword = System.getProperty("db.password");

    private final DBConnectionInfo dbConnectionInfo = new DBConnectionInfo(
            dbUrl,
            dbPort,
            dbName,
            dbUser,
            dbPassword
    );

    @SneakyThrows
    public void clearDB() {
        String creditClearSQL = "DELETE FROM credit_request_entity;";
        String paymentClearSQL = "DELETE FROM payment_entity;";
        String orderClearSQL = "DELETE FROM order_entity;";
        QueryRunner runner = new QueryRunner();
        try (
                Connection connection = DriverManager.getConnection(
                        dbConnectionInfo.getFullUrl(),
                        dbConnectionInfo.getUser(),
                        dbConnectionInfo.getPassword())
        ) {
            runner.update(connection, creditClearSQL);
            runner.update(connection, paymentClearSQL);
            runner.update(connection, orderClearSQL);
        }
    }

    @SneakyThrows
    public String getPaymentStatus() {
        String paymentStatusSQL = "SELECT status FROM payment_entity;";
        QueryRunner runner = new QueryRunner();
        try (
                Connection connection = DriverManager.getConnection(
                        dbConnectionInfo.getFullUrl(),
                        dbConnectionInfo.getUser(),
                        dbConnectionInfo.getPassword())
        ) {
            return runner.query(connection, paymentStatusSQL, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public String getCreditStatus() {
        String creditStatusSQL = "SELECT status FROM credit_request_entity;";
        QueryRunner runner = new QueryRunner();
        try (
                Connection connection = DriverManager.getConnection(
                        dbConnectionInfo.getFullUrl(),
                        dbConnectionInfo.getUser(),
                        dbConnectionInfo.getPassword())
        ) {
            return runner.query(connection, creditStatusSQL, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public long checkPaymentOrder() {
        String paymentIdSQL = "SELECT transaction_id FROM payment_entity;";
        String orderSQL = "SELECT COUNT(*) FROM order_entity WHERE payment_id = ?;";
        QueryRunner runner = new QueryRunner();
        try (
                Connection connection = DriverManager.getConnection(
                        dbConnectionInfo.getFullUrl(),
                        dbConnectionInfo.getUser(),
                        dbConnectionInfo.getPassword())
        ) {
            String  paymentId = runner.query(connection, paymentIdSQL, new ScalarHandler<>());
            return runner.query(connection, orderSQL, new ScalarHandler<>(), paymentId);
        }
    }

    @SneakyThrows
    public long checkCreditOrder() {
        String bankIdSQL = "SELECT bank_id FROM credit_request_entity;";
        String orderSQL = "SELECT COUNT(*) FROM order_entity WHERE credit_id = ?;";
        QueryRunner runner = new QueryRunner();
        try (
                Connection connection = DriverManager.getConnection(
                        dbConnectionInfo.getFullUrl(),
                        dbConnectionInfo.getUser(),
                        dbConnectionInfo.getPassword())
        ) {
            String bankId = runner.query(connection, bankIdSQL, new ScalarHandler<>());
            return runner.query(connection, orderSQL, new ScalarHandler<>(), bankId);
        }
    }
}
