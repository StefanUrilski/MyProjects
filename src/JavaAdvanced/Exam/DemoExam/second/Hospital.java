package Exam.DemoExam.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hospital {

    public static class Department {

        private String name;
        private HashMap<Integer, LinkedList<String>> patients;
        private int currRoom;

        public Department(String name) {
            this.name = name;
            this.patients = new HashMap<>();
            this.currRoom = 0;
        }

        public void addPatient(String name) {
            if (this.patients.size() == 0 || this.patients.get(this.currRoom).size() == 3) {
                this.currRoom++;
                this.patients.put(currRoom, new LinkedList<>());
            }
            if (this.patients.size() <= 20) {
                this.patients.get(this.currRoom).add(name);
            }
        }

        public LinkedList<String> getRoom(int index) {
            return this.patients.get(index);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= this.currRoom; i++) {
                this.patients.get(i).forEach(p -> sb.append(p).append(System.lineSeparator()));
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Department> departments = new HashMap<>();
        HashMap<String, TreeSet<String>> doctors = new HashMap<>();

        String input = reader.readLine();

        while (!input.equals("Output")) {
            String[] tokens = input.split("\\s+");
            String department = tokens[0];
            String doc = tokens[1] + " " + tokens[2];
            String patient = tokens[3];

            if (departments.containsKey(department)) {
                departments.get(department).addPatient(patient);

            } else {
                Department newDepartment = new Department(department);
                newDepartment.addPatient(patient);

                departments.put(department, newDepartment);
            }

            doctors.putIfAbsent(doc, new TreeSet<>());
            doctors.get(doc).add(patient);

            input = reader.readLine();
        }

        input = reader.readLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            if (tokens.length == 2) {
                try {
                    int room = Integer.valueOf(tokens[1]);
                    departments.get(tokens[0]).getRoom(room).stream().sorted().forEach(System.out::println);
                } catch (Exception e) {
                    String name = tokens[0] + " " + tokens[1];
                    doctors.get(name).forEach(System.out::println);
                }

            }  else {
                System.out.println(departments.get(tokens[0]).toString());
            }

            input = reader.readLine();
        }

    }
}
