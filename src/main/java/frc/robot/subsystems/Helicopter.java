package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Helicopter extends SubsystemBase {
    private final WPI_TalonFX mainMotor = new WPI_TalonFX(Ports.MAIN_MOTOR);
    private final WPI_TalonFX auxMotor=new WPI_TalonFX(Ports.AUX_MOTOR);
    public static Helicopter INSTANCE=null;
    public static UnitModel unitModel= new UnitModel(Constants.TICKS_PER_RAD);

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
        mainMotor.config_kP(0, Constants.KP, Constants.TALON_TIME_OUT);
        mainMotor.config_kI(0, Constants.KI, Constants.TALON_TIME_OUT);
        mainMotor.config_kD(0, Constants.KD, Constants.TALON_TIME_OUT);
    }

    public static Helicopter getInstance(){
        if (INSTANCE==null){
            INSTANCE=new Helicopter();
        }
        return INSTANCE;
    }

    public void setPower(double Power){
        mainMotor.set(Power);
    }

    public double getPower(){
        return mainMotor.get();
    }

    public void setVelocity(double Velocity){
        mainMotor.set(ControlMode.Velocity, unitModel.toTicks100ms(Velocity));
    }

    public double getVelocity(){
        return unitModel.toVelocity(mainMotor.getSelectedSensorVelocity());
    }
}
