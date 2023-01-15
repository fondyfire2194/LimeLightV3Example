// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.oi.LimeLight.StreamType;
import frc.robot.oi.LimeLightReflective.LedMode;
import frc.robot.subsystems.LimelightVision;

public class RobotContainer {
  final LimelightVision llvis = new LimelightVision();
  private CommandXboxController testController = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    testController.a().whileTrue(llvis.cam15.ref.ChangeLEDMode(LedMode.kforceBlink));
    testController.x().whileTrue(llvis.cam15.ref.ChangeLEDMode(LedMode.kpipeLine));
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
