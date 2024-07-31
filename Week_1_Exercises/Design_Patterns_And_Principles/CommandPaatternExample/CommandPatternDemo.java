package Design_Patterns_And_Principles.CommandPaatternExample;

 interface Command {
    void execute();
}

 class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }

    public void turnOff() {
        System.out.println("The light is off.");
    }
}

 class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandPatternDemo {
    public static void main(String[] args) {
        // Create a Light object (Receiver)
        Light light = new Light();

        // Create Command objects
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create RemoteControl (Invoker)
        RemoteControl remote = new RemoteControl();

        // Turn on the light
        remote.setCommand(lightOn);
        System.out.println("Pressing button to turn on the light:");
        remote.pressButton();
        System.out.println();

        // Turn off the light
        remote.setCommand(lightOff);
        System.out.println("Pressing button to turn off the light:");
        remote.pressButton();
    }
}




