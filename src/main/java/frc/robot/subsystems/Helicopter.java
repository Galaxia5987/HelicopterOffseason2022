package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

public class Helicopter extends SubsystemBase {
    private final WPI_TalonFX motor = new WPI_TalonFX(Ports.MOTOR);
    public Helicopter(){
        motor.setInverted(Ports.INVERT);
        motor.enableVoltageCompensation(Ports.ENABLE_VOLTAGE_COMPENSATION);
        motor.configVoltageCompSaturation(Ports.CONFIG_VOLTAGE_COMPSATURATION);
    }

    /**
     * set power for motor
     * @param power
     */
    public void setPower(double power){
       motor.set(power);
    }

    public double getPower(){
        return motor.get();
    }
}
