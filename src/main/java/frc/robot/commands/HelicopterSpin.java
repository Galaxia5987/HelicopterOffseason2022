package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Helicopter;

import java.util.function.DoubleSupplier;

public class HelicopterSpin extends CommandBase {
    private final Helicopter helicopter;
    private final DoubleSupplier value;

    public HelicopterSpin(Helicopter helicopter, DoubleSupplier value){
        this.helicopter=helicopter;
        this.value=value;
        addRequirements(helicopter);
    }

    /**
     * spins the helicopter and stops it with the velocity we choose
     */
    @Override
    public void execute() {
        helicopter.setVelocity(helicopter.deadBend(value.getAsDouble()));
    }

    @Override
    public void end(boolean interrupted) {
        helicopter.stopMotor();
    }
}
