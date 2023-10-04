package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ru.netology.data.CreditRequestEntity;
import ru.netology.data.PaymentEntity;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {
    private static final String URL = System.getProperty("db.url");
    private static final String USERNAME = System.getProperty("datasource.username");
    private static final String PASSWORD = System.getProperty("datasource.password");

    @SneakyThrows
    public static PaymentEntity paymentEntity() {
        String sql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        return runner.query(conn, sql, new BeanHandler<>(PaymentEntity.class));
    }

    @SneakyThrows
    public static CreditRequestEntity creditRequestEntity() {
        String sql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        return runner.query(conn, sql, new BeanHandler<>(CreditRequestEntity.class));
    }

    @SneakyThrows
    private static Connection getConnection() {
        return DriverManager.getConnection(
                URL, USERNAME, PASSWORD
        );
    }

    @SneakyThrows
    public static void cleanBD() {
        String sql = "Delete from credit_request_entity;";
        String sql1 = "Delete from order_entity;";
        String sql2 = "Delete from payment_entity;";
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        runner.execute(conn, sql);
        runner.execute(conn, sql1);
        runner.execute(conn, sql2);
    }
}
