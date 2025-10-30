package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.candymotor;

public class CandyDispense extends SubsystemBase{
    private final SparkMax candymotor = new SparkMax(Constants.candymotor.Candy_Motor, MotorType.kBrushed);
    private final SparkMaxConfig candyConfig = new SparkMaxConfig();

    
    SparkClosedLoopController candymotorpid = candymotor.getClosedLoopController();



    public CandyDispense(){
        candyConfig.idleMode(IdleMode.kBrake);
        candyConfig.inverted(Constants.candymotor.Candy_Motor_Twisted);
        candyConfig.closedLoop.feedbackSensor(FeedbackSensor.kAbsoluteEncoder).p(0.5).i(0).d(0).positionWrappingEnabled(true).positionWrappingInputRange(0,1).outputRange(-0.5, 0.5);
        candymotor.configure(candyConfig, ResetMode.kResetSafeParameters, null);
        candymotorpid.setReference(90, ControlType.kPosition);

    }
    public void setposition(candymotor, )
}
