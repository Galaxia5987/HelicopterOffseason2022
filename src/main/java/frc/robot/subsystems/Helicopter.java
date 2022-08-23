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

    /**
     * creats an instance
     * @return
     */
    public static Helicopter getInstance(){
        if (INSTANCE==null){
            INSTANCE=new Helicopter();
        }
        return INSTANCE;
    }

    /**
     * sets the power fot the motors
     * @param Power
     */
    public void setPower(double Power){
        mainMotor.set(Power);
    }

    /**
     * gets the power of the motors
     * @return
     */
    public double getPower(){
        return mainMotor.get();
    }

    /**
     * sets the velocity of the motors
     * @param Velocity
     */
    public void setVelocity(double Velocity){
        mainMotor.set(ControlMode.Velocity, unitModel.toTicks100ms(Velocity));
    }

    /**
     * gets the velocity of the motors
     * @return
     */
    public double getVelocity(){
        return unitModel.toVelocity(mainMotor.getSelectedSensorVelocity());
    }

    /**
     * stops the motors
     */
    public void stopMotor(){
        mainMotor.set(0);
    }

    /**
     * checks if the motors are in the dead zone
     * @param value
     * @return
     */
    public double deadZone(double value){
        if(value<=-Constants.DEADBEND||value>=Constants.DEADBEND){
            return 0;
        }
        else{
            return value;
        }
    }
}
