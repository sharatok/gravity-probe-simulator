import java.util.Scanner;

public class Main {
    final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        double G = 0.000000000066743;
        double Me = 5.972 * Math.pow(10.0, 24);
        double Re = 6371000;
        int coefficient = 1;
        String units = "m";
        double c = 1.0;
        int t_f = 100;
        double Mo = 10;
        double in_y = 1000;
        System.out.println();
        int ans = select("Mode select \n 1)basic values \n 2)own values \n please enter ( 1 or 2, 0 - exit )");
        if (2 == ans) {
            int ans2 = select("Mode select \n 1)Meters \n 2)Kilometers \n please enter ( 1 or 2, 0 - exit )");
            if (2 == ans2) {
                coefficient = 1000;
                units = "km";
            }
            System.out.println("Write mass of the object in kg!");
            Mo = SCANNER.nextDouble();
            System.out.println("Write initial height of the probe from earth surface in " + units + "!");
            in_y = (SCANNER.nextDouble()) * coefficient;
            System.out.println("Write observation time in seconds!");
            t_f = SCANNER.nextInt();
        }
        double t_c = 0;
        double a = 0;
        double v = 0;
        while (t_c <= t_f) {
            a = G * Me / Math.pow(Re + in_y, 2);
            in_y = in_y - (v * 0.01 + (a / 2) * (0.01) * (0.01));
            v = v + a * (0.01);
            if (in_y < 0) {
                System.out.println("Reach the surface of Earth!");
                System.out.println("Probe Reaches earth in:" + t_c + "s");
                break;
            }
            if (t_c >= c) {
                System.out.printf("Position over Earth Surface: %.3f%s\n", (in_y / coefficient), units);
                System.out.printf("Current velocity of the probe: %.3f%s\n", v, "m/s");
                System.out.printf("Current acceleration of the probe: %.3f%s\n", a, "m/s^2");
                System.out.println("Time of the observation: " + c + ("s\n"));
                c++;
            }
            t_c = t_c + 0.01;
        }
        System.out.println();
    }

    static int select(String msg) {
        do {
            System.out.println(msg);
            try {
                String input = SCANNER.nextLine();
                int val = Integer.parseInt(input);
                if (val == 1 || val == 2) {
                    return val;
                } else if (val == 0) {
                    System.exit(0);
                }
            } catch (RuntimeException ignore) {
            }
            System.out.println("enter valid value");
        } while (true);
    }
}
