package JavaOOP.ReflectionAndAnnotation.pr0304Barracks.core;

import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.*;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
	private CommandInterpreter commandInterpreter;

	public Engine(CommandInterpreter commandInterpreter) {
		this.commandInterpreter = commandInterpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");

				Executable executable = this.commandInterpreter.interpretCommand(data);

				String result = executable.execute();

				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (IOException | RuntimeException e) {
				e.printStackTrace();
			}
		}
	}
}
