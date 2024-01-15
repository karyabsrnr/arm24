// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;

public class Arm extends ProfiledPIDSubsystem {
  public final CANSparkMax m_spark = new CANSparkMax(6,MotorType.kBrushless);
  public final RelativeEncoder encoder_arm = m_spark.getEncoder();
  /** Creates a new Arm. */
  //public final CANSparkMax spark = new CANSparkMax (14, MotorType.kBrushless);
 // public final RelativeEncoder encoderS = spark.getEncoder();
    
  
  public Arm() {
    super(
        // The ProfiledPIDController used by the subsystem
        new ProfiledPIDController(
            0.35,
            0,
            0,
            // The motion profile constraints
            new TrapezoidProfile.Constraints(50, 50)));
  }

  @Override
  public void useOutput(double output, TrapezoidProfile.State setpoint) {
    // Use the output (and optionally the setpoint) here
   m_spark.set(output);
  }

  public void resetEncoders() {
    encoder_arm.setPosition(-0);
   
   
  }

 public double getEncoderPos(){

   return encoder_arm.getPosition();

 }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return 0;
  }
}
