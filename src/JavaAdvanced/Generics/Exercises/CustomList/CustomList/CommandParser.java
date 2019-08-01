package Generics.Exercises.CustomList.CustomList;

public class CommandParser {
    private SmartArray<String> smartArray;

    public CommandParser() {
        this.smartArray = new SmartArray<>();
    }

    public void execute(String command) {
        String[] commands = command.split("\\s+");

        switch (commands[0]) {
            case "Add":
                this.smartArray.add(commands[1]);
                break;
            case "Remove":
                this.smartArray.remove(Integer.valueOf(commands[1]));
                break;
            case "Contains":
                System.out.println(this.smartArray.contains(commands[1]));
                break;
            case "Swap":
                this.smartArray.swap(Integer.valueOf(commands[1]), Integer.valueOf(commands[2]));
                break;
            case "Greater":
                System.out.println(this.smartArray.greaterThen(commands[1]));
                break;
            case "Sort":
                Sorting.sort(this.smartArray);
                break;
            case "Max":
                System.out.println(this.smartArray.max());
                break;
            case "Min":
                System.out.println(this.smartArray.min());
                break;
            case "Print":
                for (String s : this.smartArray) {
                    System.out.println(s);
                }
                //this.smartArray.print(System.out::println);
                break;
        }
    }

}
