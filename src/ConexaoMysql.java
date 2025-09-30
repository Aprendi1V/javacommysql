import java.sql.*;
public class ConexaoMysql {
    
    public static String URL =
       "jdbc:mysql://localhost:3306/aprendi1v";
    public static String USER = "root";
    public static String PWD = "root"; // atenção a instalacao padrao XAMP a senha é "" 

    // objetos de conexão
    private Connection dbconn = null;
    private Statement sqlmgr = null;
    private ResultSet resultsql = null;

    public void OpenDatabase (){

     try {
        dbconn = DriverManager.getConnection(URL, USER, PWD);
        System.out.println("Conectado com sucesso em: "+URL);
        sqlmgr = dbconn.createStatement(); // cria objeto para SQLs
     } catch (Exception Error)
     {
        System.out.println("Error on connect: "+Error.getMessage());
     }

    }

    public void CloseDatabase() throws SQLException{
        sqlmgr.close();
        dbconn.close();
    }

    // Minha função FINAL
    // Retorna o total de registros afetados ou -1 caso ocorreu algum erro
    public int ExecutaQuery(String sql) {
        try {
            return sqlmgr.executeUpdate(sql); // insert/delete/update/create
        } catch (Exception Error)
        {
              System.out.println("Error on connect: "+Error.getMessage());
        }
        return -1;
    }


}
