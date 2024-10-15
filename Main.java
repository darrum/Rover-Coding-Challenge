import java.util.Scanner;

class Rover {
    int direction = 0;
    int x = 0;
    int y = 0;
    int speed = 1;

    // direction == 0 up, 1 down, 2 right, 3 left

    public void right() {
        switch (direction) {
            case 0:
                direction = 1;
                break;
            case 1:
                direction = 2;
                break;
            case 2:
                direction = 3;
                break;
            case 3:
                direction = 0;
                break;
        }
    }
    public void left() {
        switch (direction) {
            case 0:
                direction = 3;
                break;
            case 1:
                direction = 2;
                break;
            case 2:
                direction = 1;
                break;
            case 3:
                direction = 0;
                break;
        }
    }
    public void move() {
        switch (direction) {
            case 3:
                x -= speed;
                break;
            case 1:
                x += speed;
                break;
            case 2:
                y += speed;
                break;
            case 0:
                y -= speed;
                break;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("input command:");
        Scanner sc = new Scanner(System.in);
        Rover rv = new Rover();

        char command;

        while (sc.hasNext()) {
            String expr = sc.next();

            for (int i = 0; i < expr.length(); i++) {
                command = expr.charAt(i);
                switch (command) {
                    case 'L':
                        rv.left();
                        break;
                    case 'R':
                        rv.right();
                        break;
                    case 'M':
                        rv.move();
                        break;
                    case 'A':
                        rv.speed++;
                        System.out.printf("Your speed is %s times faster now \n", rv.speed);
                        break;
                    case 'B':
                        rv.speed--;
                        System.out.printf("Your speed is %s times slower now \n", rv.speed);
                        break;
                }
            }
            result(rv.x,rv.y,rv.direction);
        }
    }
    public static void result(int x, int y, int d) {
        System.out.printf("Current position is (%s,%s)\n",x,y);
        System.out.printf("Current direction is %s\n",d);
    }
}
