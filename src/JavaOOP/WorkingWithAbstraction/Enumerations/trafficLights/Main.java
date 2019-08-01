package JavaOOP.WorkingWithAbstraction.Enumerations.trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] states = reader.readLine().split("\\s+");

        int updateCount = Integer.parseInt(reader.readLine());

        List<TrafficLight> lights = new ArrayList<>();

        for (String state : states) {
            TrafficLight trafficLight = new TrafficLight(LightStates.valueOf(state));

            lights.add(trafficLight);
        }

        StringBuilder sb = new StringBuilder();

        while (updateCount-- > 0) {
            for (TrafficLight light : lights) {
                light.update();
                sb.append(light).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.print(sb.toString());
    }
}
