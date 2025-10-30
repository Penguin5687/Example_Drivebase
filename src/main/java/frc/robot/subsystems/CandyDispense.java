package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CandyDispense extends SubsystemBase{
    private final SparkMax candymotor = new SparkMax(Constants.candymotor.Candy_Motor, MotorType.kBrushed);
    private final SparkMaxConfig candyConfig = new SparkMaxConfig();
    
    // Initialize the closed loop controller
    SparkClosedLoopController candymotorpid = candymotor.getClosedLoopController();

    public CandyDispense(){
        candyConfig.idleMode(IdleMode.kBrake);
        candyConfig.inverted(Constants.candymotor.Candy_Motor_Twisted);
        candymotor.configure(candyConfig, ResetMode.kResetSafeParameters, null);
        candymotorpid.setReference(setPoint, ControlType.kPosition);

    }
}
