// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Arm;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public final XboxController opJoy = new XboxController(1);
  public final Arm m_Arm = new Arm();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    m_Arm.m_spark.setSmartCurrentLimit(10);
  }

  public void teleopPeriodic(){

    double setpoint1 = -20; // when using relative encoder, use numbers in the set of -0.1 to 0.1
    double setpoint2 = 40; // ^^ this should be a double
    double setpoint3 = -62; // These numbers are for an absolute encoder

    if(opJoy.getBButton()){
      m_Arm.setGoal(setpoint1);
      m_Arm.enable();
    }else if(opJoy.getYButton()){
      m_Arm.setGoal(setpoint2);
      m_Arm.enable();
    }else if(opJoy.getAButton()){
      m_Arm.setGoal(0);
      m_Arm.enable();
    }else if(opJoy.getXButton()){
      m_Arm.setGoal(setpoint3);
      m_Arm.enable();
    }

    m_Arm.encoder_arm.getPosition();
    SmartDashboard.putNumber("Encoder for Arm", m_Arm.encoder_arm.getPosition());
    
    
  }
   public void disableArm(){
      m_Arm.disable();
    }

  

  // if(opJoy.getBButton()){
  //   m_Arm.m_spark.set(0.1);
  // }

  /*if(opJoy.getAButton()){
    m_Arm.disable();
  }
  */




  
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   *  @return the command to run in autonomous
   */

  

  
}

