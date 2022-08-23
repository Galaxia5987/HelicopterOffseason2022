package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Util extends SubsystemBase {
    /**
     *  removes drift
     */
    public double convertDeadBand( double power, double deadband){
        if(power>0.05){
            return power-deadband;
        }
        else{
            return 0;
        }
    }
}
