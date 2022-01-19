package utils;

public class ConsoleLogger implements Logger {
    Object object;

    @Override
    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public void logClass() {
        System.out.println("Running: " + object.getClass());
    }
}
