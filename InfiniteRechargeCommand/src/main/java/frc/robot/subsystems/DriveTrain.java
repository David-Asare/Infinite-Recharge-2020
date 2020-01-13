/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  private CANSparkMax leftMotor = new CANSparkMax(RobotMap.leftDrive, MotorType.kBrushless);
  private CANSparkMax rightMotor = new CANSparkMax(RobotMap.rightDrive, MotorType.kBrushless);

  private CANSparkMax leftMotorFollow = new CANSparkMax(RobotMap.leftDriveFollow, MotorType.kBrushless);
  private CANSparkMax rightMotorFollow = new CANSparkMax(RobotMap.rightDriveFollow, MotorType.kBrushless);
  
  SpeedControllerGroup m_left = new SpeedControllerGroup(leftMotor, leftMotorFollow);
  SpeedControllerGroup m_right = new SpeedControllerGroup(rightMotor, rightMotorFollow);


  private DifferentialDrive myDrive = new DifferentialDrive(m_left, m_right);

  public void drive(double y, double x){
    myDrive.arcadeDrive(y,x);
  }// public void drive


}
