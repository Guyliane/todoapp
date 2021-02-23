package sample.repository;

import sample.Database.Const;
import sample.Database.DataSourceProvider;
import sample.entity.Utilisateur;

import javax.sql.DataSource;
import java.sql.*;

public class UtilisateurRepositoryImpl {

    public void create(Utilisateur utilisateur){
        Connection conn = null;
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO "+ Const.UTILISATEURS_TABLE+"("+Const.UTILISATEURS_NOM+","+Const.UTILISATEURS_PRENOM+","+Const.UTILISATEURS_PSEUDO
                    +","+Const.UTILISATEURS_MOTDEPASSE+","+Const.UTILISATEURS_SEXE+")"+"VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getPseudo());
            preparedStatement.setString(4, utilisateur.getMotdepasse());
            preparedStatement.setString(5, utilisateur.getSexe());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if(rs.next()){
                utilisateur.setId(rs.getInt(1));
            }

            System.out.println("Utilisateur ajouté");

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

    public ResultSet getUtilisateur(Utilisateur utilisateur){
        ResultSet resultSet =null;
        Connection conn = null;
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn=dataSource.getConnection();

            if(!utilisateur.getPseudo().equals("") || !utilisateur.getMotdepasse().equals(""))
            {
                String query = "SELECT * FROM " + Const.UTILISATEURS_TABLE + " WHERE " + Const.UTILISATEURS_PSEUDO + "=?"
                        + " AND "+ Const.UTILISATEURS_MOTDEPASSE + "=?";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, utilisateur.getPseudo());
                preparedStatement.setString(2, utilisateur.getMotdepasse());

                resultSet = preparedStatement.executeQuery();



            }else
            {
                System.out.println("Veuillez entrer vos informations de connexion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*finally {
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        return resultSet;
    }
}
