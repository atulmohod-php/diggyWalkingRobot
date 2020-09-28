
public class Main {

	static int x_pos_new = 0;
	static int y_pos_new = 0;

	public static void main(String[] arg) {
		try {
			int x_pos_current = Integer.parseInt(arg[0].trim());
			int y_pos_current = Integer.parseInt(arg[1].trim());
			String direction_current = arg[2].trim();
			char[] walk_string = arg[3].trim().toLowerCase().toCharArray();

			String new_position = walkDiggy(x_pos_current, y_pos_current, direction_current, walk_string);

			System.out.println(new_position);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static String walkDiggy(int x_pos_current, int y_pos_current, String direction_current,
			char[] walk_string) {
		// TODO Auto-generated method stub
		
		x_pos_new=x_pos_current;
		y_pos_new=y_pos_current;
		String curr_dir = direction_current.toLowerCase();

		boolean readUnit = false;
		String totalUnits = "";

		for (char pos : walk_string) {

			if (readUnit) {
				if (Character.isDigit(pos)) {
					totalUnits = totalUnits + "" + pos;
				} else {
					calculateUnits(curr_dir, totalUnits);
					totalUnits = "";
					readUnit = false;
				}
			}

			switch (pos) {
			case 'r':
				curr_dir = clockDirection(curr_dir);
				break;
			case 'l':
				curr_dir = antiClockDirection(curr_dir);
				break;
			case 'w':
				readUnit = true;
				break;
			}
		}

		return x_pos_new + " " + y_pos_new + " " + curr_dir;
	}

	private static void calculateUnits(String curr_dir, String totalUnits) {
		// TODO Auto-generated method stub
		switch (curr_dir) {
		case "north":
			y_pos_new = y_pos_new+Integer.parseInt(totalUnits);
			break;
		case "east":
			x_pos_new = x_pos_new+Integer.parseInt(totalUnits);
			break;
		case "south":
			y_pos_new = y_pos_new-Integer.parseInt(totalUnits);
			break;
		case "west":
			x_pos_new = x_pos_new-Integer.parseInt(totalUnits);
			break;
		}
	}

	private static String antiClockDirection(String curr_pos) {
		// TODO Auto-generated method stub

		String new_pos = "";
		if (curr_pos != null) {
			switch (curr_pos) {
			case "north":
				new_pos = "west";
				break;
			case "east":
				new_pos = "north";
				break;
			case "south":
				new_pos = "east";
				break;
			case "west":
				new_pos = "south";
				break;
			}
		}
		return new_pos;
	}

	private static String clockDirection(String curr_pos) {
		// TODO Auto-generated method stub

		String new_pos = "";
		if (curr_pos != null) {
			switch (curr_pos) {
			case "north":
				new_pos = "east";
				break;
			case "east":
				new_pos = "south";
				break;
			case "south":
				new_pos = "west";
				break;
			case "west":
				new_pos = "north";
				break;
			}
		}
		return new_pos;
	}

}
