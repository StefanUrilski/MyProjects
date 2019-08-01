package JavaOOP.ReflectionAndAnnotation.pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		RichSoilLand soilLand = new RichSoilLand();

		Field[] fields = soilLand.getClass().getDeclaredFields();

		String line = reader.readLine();
		while (!line.equals("HARVEST")) {
			getFieldByModifier(fields, line);

			line = reader.readLine();
		}
	}

	private static void getFieldByModifier(Field[] fields, String modifierName) {
		for (Field field : fields) {
			if (Modifier.toString(field.getModifiers()).equals(modifierName)) {
				System.out.println(String.format("%s %s %s",
						Modifier.toString(field.getModifiers()),
						field.getType().getSimpleName(),
						field.getName()
						));
			} else if (modifierName.equals("all")) {
				System.out.println(String.format("%s %s %s",
						Modifier.toString(field.getModifiers()),
						field.getType().getSimpleName(),
						field.getName()
				));
			}
		}
	}
}
