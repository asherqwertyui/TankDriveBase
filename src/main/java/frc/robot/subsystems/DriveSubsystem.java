// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
   // Creating all our variables, we will initialize them and set their values later
   //create motors : motorcontrolers are talon srx/ talon fx in code : check pheonix 5 docs
   //create differential drive or arcade drive : check WPILib docs
  
  WPI_TalonFX leftLeader;
  WPI_TalonFX rightLeader;
  WPI_TalonFX leftFollower;
  WPI_TalonFX rightFollower;
  DifferentialDrive drive;
  public DriveSubsystem() { 
     //initialize motor controllers
     leftLeader = new WPI_TalonFX(6);
     rightLeader = new WPI_TalonFX(8);
     leftFollower = new WPI_TalonFX(5);
     rightFollower = new WPI_TalonFX(7);
     //set to factory defaults
    leftLeader.configFactoryDefault();
    rightLeader.configFactoryDefault();
    leftFollower.configFactoryDefault();
    rightFollower.configFactoryDefault();
     //set motors to default to braking
    leftLeader.setNeutralMode(NeutralMode.Brake);
    rightLeader.setNeutralMode(NeutralMode.Brake);
    leftFollower.setNeutralMode(NeutralMode.Brake);
    rightFollower.setNeutralMode(NeutralMode.Brake);
    //create differential drive
    drive = new DifferentialDrive(leftLeader, rightLeader);
    //Makes follower motors do the same thing as the leaders so that we don't have to pass arguments for all four
    

    // invert left motors from the right motors because they are inverted 180 degrees
    
    
    
    
  }

  public void drive(double left, double right) {
    //Drive command
    drive.tankDrive(left, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
