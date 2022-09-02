package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

public class Helicopter extends SubsystemBase {
    private final WPI_TalonFX aux_motor = new WPI_TalonFX(Ports.MOTOR);

    private final WPI_TalonFX main_motor = new WPI_TalonFX(Ports.MOTOR);

    private static Helicopter INSTANCE = null;

    public Helicopter(){
        main_motor.setInverted(Ports.INVERT);
        main_motor.enableVoltageCompensation(Ports.ENABLE_VOLTAGE_COMPENSATION);
        main_motor.configVoltageCompSaturation(Ports.CONFIG_VOLTAGE_COMPSATURATION);
        aux_motor.follow(main_motor);
    }

    /**
     * set power for motor
     * @param power
     */
    public void setPower(double power){
       main_motor.set(power);
    }

    public double getPower(){
        return main_motor.get();
    }

    public static Helicopter getINSTANCE(){
        if(INSTANCE == null)
            INSTANCE = new Helicopter();
        return INSTANCE;
    }
}
