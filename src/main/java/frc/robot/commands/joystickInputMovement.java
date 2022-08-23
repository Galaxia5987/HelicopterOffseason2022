package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Util;
import frc.robot.subsystems.Choppa;

import java.util.function.DoubleSupplier;

public class joystickInputMovement extends CommandBase {

    private final Choppa choppa;
    private final Util util;
    private final DoubleSupplier joyStickInput;

    public joystickInputMovement(Choppa choppa, Util util, DoubleSupplier joyStick) {
        this.choppa = choppa;
        this.util = util;
        this.joyStickInput = joyStick;
    }


    /**
     * set power to power%
     */
    @Override
    public void execute() {
        double power = util.convertDeadBand(joyStickInput.getAsDouble(), 0.05);
        choppa.setPower(power);
    }

    /**
     * set power to 0%
     */
    @Override
    public void end(boolean interrupted) {
        choppa.setPower(0);
    }
}
