package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.hal.ConstantsJNI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Choppa extends SubsystemBase {
    private final WPI_TalonFX mainMotor = new WPI_TalonFX(0);
    private final WPI_TalonFX auxMotor = new WPI_TalonFX(0);
    private final Choppa INSTANCE = new Choppa();
    private Choppa(){
        mainMotor.configVoltageCompSaturation();
        mainMotor.enableVoltageCompensation(true);
        mainMotor.setInverted(true);
        auxMotor.follow(mainMotor);
        mainMotor.config_kD(0, Constants.Choppa.kD,Constants.TalonTimeout);
        mainMotor.config_kP(0, Constants.Choppa.kP,Constants.TalonTimeout);
        mainMotor.config_kI(0, Constants.Choppa.kI,Constants.TalonTimeout);
    }
    public void setPower(double power){
        mainMotor.set(power);
    }
    public double getPower(){
        return mainMotor.get();
    }

    public Choppa getINSTANCE() {
        if (INSTANCE == null){
            return new Choppa();
        }
        return INSTANCE;
    }

}
