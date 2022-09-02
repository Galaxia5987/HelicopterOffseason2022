package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.DoubleSupplier;

public class JoystickPower extends CommandBase {
    /**
     * set helicopter and supplier
     */
    private final Helicopter helicopter;
    private final DoubleSupplier joystickvalue;

    public JoystickPower(Helicopter helicopter, DoubleSupplier joystickvalue) {
        this.helicopter = helicopter;
        this.joystickvalue = joystickvalue;
    }

    /**
     * excute and end
     */
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        helicopter.setPower(joystickvalue.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        helicopter.setPower(0);
    }
}


