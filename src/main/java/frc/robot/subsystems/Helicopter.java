package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Helicopter extends SubsystemBase {
    private final WPI_TalonFX mainMotor = new WPI_TalonFX(Ports.MAIN_MOTOR);
    private final WPI_TalonFX auxMotor=new WPI_TalonFX(Ports.AUX_MOTOR);

    public Helicopter(){
        mainMotor.setInverted(Ports.INVERTED);
        auxMotor.setInverted(Ports.INVERTED);
        mainMotor.setNeutralMode(NeutralMode.Brake);
        auxMotor.setNeutralMode(NeutralMode.Brake);
        mainMotor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        auxMotor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        mainMotor.configVoltageCompSaturation(Constants.CONFIG_VOLTAGE_COMP);
        auxMotor.configVoltageCompSaturation(Constants.CONFIG_VOLTAGE_COMP);
        auxMotor.follow(mainMotor);
        mainMotor.configMotionAcceleration(Constants.MAX_ACCELERATION);
        mainMotor.configMotionCruiseVelocity(Constants.VELOCITY_CRUISE);
    }


}
