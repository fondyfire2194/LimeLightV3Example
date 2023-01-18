// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.oi.ShuffleboardLL;
import frc.robot.oi.LimeLight.LedMode;
import frc.robot.subsystems.LimelightVision;

public class RobotContainer {
  final LimelightVision llvis;
  private ShuffleboardLL cam1Disp;
  

  private CommandXboxController testController = new CommandXboxController(3);

  public RobotContainer() {
    llvis = new LimelightVision();
    
    cam1Disp = new ShuffleboardLL(llvis.cam15);
  
    configureBindings();

  }

  private void configureBindings() {
    testController.a().whileTrue(llvis.cam15.ChangeLEDMode(LedMode.kforceBlink));
    testController.x().whileTrue(llvis.cam15.ChangeLEDMode(LedMode.kpipeLine));
    testController.b().whileTrue(llvis.cam15.GetSnapShot());

    testController.y().whileTrue(llvis.cam15.ToggleCamMode());
    testController.leftBumper().whileTrue(llvis.cam15.ChangePipeline(LimelightVision.cam15Pipelines.get("PL0")));
    testController.rightBumper().whileTrue(llvis.cam15.ChangePipeline(LimelightVision.cam15Pipelines.get("PL5")));
    double[] crop1 = { .5, .25, .8, .7 };
    testController.back().whileTrue((llvis.cam15.ChangeCropRectangle(crop1)));

    double[] crop2 = { -.1, .3, -.7, .3 };
    testController.start().whileTrue(llvis.cam15.ChangeCropRectangle(crop2));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
