import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAOStatisticJDBC implements DAOStatistic{

    private static String url = "jdbc:mysql://localhost:3306/statDB";
    private static String username = "root";
    private static String pass = "root";
    private static DAOStatistic daoStatistic;

    public DAOStatisticJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DAOStatistic getInstance(){
        if(daoStatistic == null){
            synchronized (DAOStatistic.class){
                if(daoStatistic == null){
                    daoStatistic = new DAOStatisticJDBC();
                }
            }
        }
        return daoStatistic;
    }

    @Override
    public void insertList(List<Statistic> list) {
        try(Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement("INSERT INTO stat (longest_word, shortest_word, line_length, average_word_length) values (?,?,?,?)")){
            for (Statistic statE: list) {
                stat.setString(1, statE.getLongestWord());
                stat.setString(2, statE.getShortestWord());
                stat.setInt(3, statE.getLineLength());
                stat.setDouble(4, statE.getAverageWordLength());
                stat.addBatch();
            }
            stat.executeBatch();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection(url, username, pass);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
