
class Move {

    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction directionX = (toX - robot.getX() > 0) ? Direction.RIGHT : Direction.LEFT;
        Direction directionY = (toY - robot.getY() > 0) ? Direction.UP : Direction.DOWN;

        rotateTo(robot, directionX);

        while (robot.getX() != toX) {
            robot.stepForward();
            System.out.println(robot.getX() + " " + robot.getY() + " " + robot.getDirection().toString());
        }

        rotateTo(robot, directionY);

        while (robot.getY() != toY) {
            robot.stepForward();
            System.out.println(robot.getX() + " " + robot.getY() + " " + robot.getDirection().toString());
        }
    }

    public static void rotateTo(Robot robot, Direction direction) {

        if (robot.getDirection() == direction) {
            return;
        }

        if (robot.getDirection().dy() + direction.dy() == 0 || robot.getDirection().dx() + direction.dx() == 0) {
            robot.turnLeft();
            robot.turnLeft();
            return;
        }

        if (robot.getDirection().dy() == 0) {
            if (robot.getDirection().dx() + direction.dy() == 0) {
                robot.turnRight();
            } else {
                robot.turnLeft();
            }
        } else {
            if (robot.getDirection().dy() + direction.dx() == 0) {
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    LEFT(-1, 0),
    DOWN(0, -1),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}