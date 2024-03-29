/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class OpenerCMD extends Command {
  public OpenerCMD() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.opener);
  }
  double currenttime;
  boolean ifFinished;
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    currenttime = Timer.getFPGATimestamp();
    ifFinished = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Timer.getFPGATimestamp()<currenttime + 10000){

    Robot.opener.open();
    ifFinished = false;
    }else{
      ifFinished = true;
    }

    }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return ifFinished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.opener.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.opener.stop();

  }
}
