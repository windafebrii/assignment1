import com.enigma.model.Directions;
import com.enigma.model.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input Koordinat x,y,DIRECTIONS: ");
        String koordinat = reader.readLine();
        String [] posts = koordinat.split(",");

        Robot robot = new Robot(Integer.parseInt(posts[0]), Integer.parseInt(posts[1]), Directions.valueOf(posts[2]));

        System.out.print("Input Comands: ");
        robot.setCommands(reader.readLine());
        robot.run();

        System.out.println(robot.print());
    }
}
