package app.database;

import java.sql.*;

public class DbManager {

    private static final String CONN = "jdbc:sqlite:QuoteDatabase.db";

    private static Connection connect() {

        Connection conn = null;
        if(isSuitableDriverAvailable()) {
            try {
                conn = DriverManager.getConnection(CONN);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.err.println("The driver was not correctly loaded and execution was aborted");
        }
        return conn;
    }

    private static boolean isSuitableDriverAvailable() {
        return false;
    }

    public static void insert(Integer id, String name, String text) {

        String sql2 = "INSERT INTO [quote] (\n" +
                "                      name,\n" +
                "                      text,\n" + 
                "                          )\n" +
                "                   VALUES (\n" +
                "                         ?,\n" +
                "                         ?,\n" +
                "                           );";

        try (Connection conn = connect();
            PreparedStatement preSTMT = conn.prepareStatement(sql2)){
                preSTMT.setString(1, name);
                preSTMT.setString(2, text);

                preSTMT.execute();
            System.out.println("Message to Mr Matthew");    
        } 
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

//     public static List<String> listQuote(){
//         String sql = "SELECT * FROM [quote]";
//         List<String> worldList = new ArrayList<>();

//         try (Connection conn = connect();
//             Statement stmt  = conn.createStatement();
//             ResultSet rs    = stmt.executeQuery(sql)){

//             // loop through the result set
//             while (rs.next()) {
// //                System.out.println(rs.getString("WorldID"));
//                 worldList.add(rs.getString("WorldID"));
//             }
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         }

//         return worldList;
//     }

//     private static boolean isSuitableDriverAvailable() {
//         try {
//             Class.forName("org.sqlite.JDBC");
//         } catch(ClassNotFoundException ex) {
//             return false;
//         }

//         return true;
//     }

//     public static void restoreData(World world, String name) {
//         try (
//                 Connection conn = connect();
//                 Statement stmt = conn.createStatement();
//         ){
//             if(checkWorldID(name)) {
//                 String getWorld = "SELECT * FROM 'Robot Worlds' WHERE WorldID='" + name + "'";
//                 ResultSet rs = stmt.executeQuery(getWorld);
//                 while(rs.next()) {
//                     getAndSetData(rs, world);
//                 }
//             } else {
//                 restoreData(world);
//             }
            
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         }
//     }

//     public static void restoreData(World world) {
//         String defaultWorld = "SELECT * FROM 'Robot Worlds' WHERE WorldID='World01'";

//         try (Connection conn = connect();
//                 Statement stmt = conn.createStatement();
//                 ResultSet rs = stmt.executeQuery(defaultWorld);
//                 ) {
//             while (rs.next()) {
//                 getAndSetData(rs, world);
//             }
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         }
//     }

//     private static void getAndSetData(ResultSet rs, World world) {
//         JSONParser parser = new JSONParser();
//         try {
//             Position bottomRight = createPosition(rs.getString("BottomRight"));
//             Position topLeft = createPosition(rs.getString("TopLeft"));
//             int maxShields = rs.getInt("MaxShields");
//             int maxShots = rs.getInt("MaxShots");
//             int reloadTime = rs.getInt("ReloadTime");
//             int repairTime = rs.getInt("RepairTime");
//             int visibility = rs.getInt("Visibility");
//             int mineSetTime = rs.getInt("MineSetTime");

//             JSONObject maze = (JSONObject) parser.parse(rs.getString("Maze"));
//             Vector<Obstacle> obstacleList = getObstacles((JSONArray) maze.get("obstaclesList"));

//             world.changeWorldConfig(bottomRight, topLeft, maxShields, maxShots, reloadTime, repairTime, visibility,
//                     mineSetTime, obstacleList);
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//     }

//     private static Vector<Obstacle> getObstacles(JSONArray obstacleList) {
//         Vector<Obstacle> obs = new Vector<>();
//         for (int i = 0; i < obstacleList.size(); i++) {
//             JSONObject obstacle = (JSONObject) obstacleList.get(i);
//             Position obsPosition = new Position(((Long) obstacle.get("bottomLeftX")).intValue(),
//                     ((Long) obstacle.get("bottomLeftY")).intValue());
//             obs.add(new SquareObstacle(obsPosition.getX(), obsPosition.getY()));
//         }
//         return obs;
//     }

//     private static Position createPosition(String positionString) {
//         return new Position(Integer.parseInt(positionString.split(",")[0]),
//         Integer.parseInt(positionString.split(",")[1]));
//     }
}