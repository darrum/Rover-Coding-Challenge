import java.util.Scanner;

class Rover {
    int direction = 0;
    int x = 0;
    int y = 0;
    int speed = 1;


    // Right turn
    public void right(int intRepeats) {
        direction += intRepeats;
        direction %= 4;
    }

    // Left turn
    public void left(int intRepeats) {
        direction -= intRepeats;
        while (direction < 0) { direction += 4; }
    }

    //Step further
    public void move(int intRepeats) {
        switch (direction) {
            case 3:
                x -= speed * intRepeats;
                break;
            case 1:
                x += speed * intRepeats;
                break;
            case 2:
                y -= speed * intRepeats;
                break;
            case 0:
                y += speed * intRepeats;
                break;
        }
    }
    public void accelerate(int intRepeats) {
        speed += intRepeats;
        System.out.printf("Rover's speed is %s times faster now \n", speed);
    }
    public void breaking(int intRepeats) {
        speed -= intRepeats;
        if (speed >= 1) {
            System.out.printf("Rover's speed is %s times slower now \n", speed);
        } else {
            speed = 1;
            System.out.println("Rover's speed can't be less than 1");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Here is a list of commands:\n L - left turn\nR - right turn\nM - move further\nA - accelerate\nB - break\nF - finish");
        System.out.println("input command:");
        Scanner sc = new Scanner(System.in);
        Rover rv = new Rover();

        char command;

        while (sc.hasNext()) {
            String expr = sc.next();
            String upperCase = expr.toUpperCase();

            for (int i = 0; i < upperCase.length(); i++) {
                command = upperCase.charAt(i);

                if (Character.isAlphabetic(command)) {
                    StringBuilder strRepeats = new StringBuilder();

                    while (i < upperCase.length() - 1 && Character.isDigit(upperCase.charAt(i+1))) {
                        strRepeats.append(upperCase.charAt(i + 1));
                        ++i;
                    }

                    if (strRepeats.isEmpty()){
                        strRepeats = new StringBuilder("1");
                    }

                    //Amount of repeating commands
                    int intRepeats = Integer.parseInt(strRepeats.toString());

                    switch (command) {
                        case 'L':  //left
                            rv.left(intRepeats);
                            break;
                        case 'R':  //right
                            rv.right(intRepeats);
                            break;
                        case 'M':  //move
                            rv.move(intRepeats);
                            break;
                        case 'A':  //accelerate
                            rv.accelerate(intRepeats);
                            break;
                        case 'B':  //break
                            rv.breaking(intRepeats);
                            break;
                        case 'F':
                            sc.close();
                            result(rv.x, rv.y, rv.direction);
                            System.out.println("Exiting the program...");
                            return;
                        default:
                            System.out.println("Wrong command");
                    }
                } else {
                    System.out.println("You can use alphanumeric characters only");
                }
                result(rv.x, rv.y, rv.direction);   //Final destination
            }
        }
    }
    public static void result ( int x, int y, int d) {
        String[] directions = {"UP","RIGHT","DOWN","LEFT"};
        System.out.printf("Current position is (%s,%s)\n", x, y);
        System.out.printf("Current direction is %s\n", directions[d]);
    }
}