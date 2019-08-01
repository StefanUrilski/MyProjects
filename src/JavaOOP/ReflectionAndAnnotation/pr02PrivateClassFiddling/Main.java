package JavaOOP.ReflectionAndAnnotation.pr02PrivateClassFiddling;

import JavaOOP.ReflectionAndAnnotation.pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line = reader.readLine();

		Constructor<BlackBoxInt> blackBoxIntConstructor = BlackBoxInt.class.getDeclaredConstructor();

		blackBoxIntConstructor.setAccessible(true);

		BlackBoxInt box = blackBoxIntConstructor.newInstance();

		Field field = box.getClass().getDeclaredField("innerValue");

		while (!line.equals("END")) {
			String[] tokens = line.split("_");
			Method curr = box.getClass().getDeclaredMethod(tokens[0], int.class);
			curr.setAccessible(true);
			curr.invoke(box, Integer.parseInt(tokens[1]));
			field.setAccessible(true);
			System.out.println(field.getInt(box));
			line = reader.readLine();
		}

	}
}
