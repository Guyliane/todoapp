package sample.repository;

import sample.Database.Const;
import sample.Database.DataSourceProvider;
import sample.entity.Task;
import sample.entity.Utilisateur;

import javax.sql.DataSource;
import java.sql.*;

public class TaskRepositoryImpl {

    public void create(Task task){
        Connection conn = null;
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO "+ Const.TASKS_TABLE+"("+Const.TASKS_TITRE+","+Const.TASKS_DESCRIPTION+","+Const.TASKS_DATE+")"+"VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, task.getTasktitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getDatecreated());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if(rs.next()){
                task.setTaskid(rs.getInt(1));
            }

            System.out.println("Task ajouté");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
