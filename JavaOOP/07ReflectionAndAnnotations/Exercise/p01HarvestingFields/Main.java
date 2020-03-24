package p01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Class<?> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		Scanner scanner = new Scanner(System.in);

		for (String command = scanner.nextLine(); !command.equals("HARVEST"); command = scanner.nextLine()) {
			switch(command) {
				case "private":
					handlePrivateFields(fields);
					break;
				case "protected":
					handleProtectedFields(fields);
					break;
				case "public":
					handlePublicFields(fields);
					break;
				case "all":
					handleAllFields(fields);
					break;
			}
		}

		scanner.close();

	}

	private static void handleAllFields(Field[] fields) {
		Arrays.stream(fields)
			.forEach(f -> {
				String modifer = Modifier.toString(f.getModifiers());
				printField(f);
			});
	}

	private static void handlePublicFields(Field[] fields) {
		Arrays.stream(fields)
			.filter(f -> Modifier.isPublic(f.getModifiers()))
			.forEach(f -> {
				printField(f);
			});
	}

	private static void handleProtectedFields(Field[] fields) {
		Arrays.stream(fields)
			.filter(f -> Modifier.isProtected(f.getModifiers()))
			.forEach(f -> {
				printField(f);
			});
	}

	private static void handlePrivateFields(Field[] fields) {
		Arrays.stream(fields)
			.filter(f -> Modifier.isPrivate(f.getModifiers()))
			.forEach(f -> {
				printField(f);
			});
	}

	private static void printField(Field f) {
		System.out.println(String.format(
			"%s %s %s",
			Modifier.toString(f.getModifiers()),
			f.getType().getSimpleName(),
			f.getName()
		));
	}
}
