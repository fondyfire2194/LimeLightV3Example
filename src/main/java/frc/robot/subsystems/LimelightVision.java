// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.oi.LimeLight;
import frc.robot.oi.LimeLight.CamMode;
import frc.robot.oi.LimeLight.LedMode;
import frc.robot.oi.LimeLight.StreamType;

public class LimelightVision extends SubsystemBase {
  /** Creates a new LimelightVision. */

  public LimeLight cam15;


  public LimeLight cam16;


  private int numCams = 1;

  public static Map<String, Integer> cam15Pipelines;
  static {
    cam15Pipelines = new HashMap<>();
    cam15Pipelines.put("PL0", 0);
    cam15Pipelines.put("PL1", 1);
    cam15Pipelines.put("PL2", 2);
    cam15Pipelines.put("PL3", 3);
    cam15Pipelines.put("PL4", 4);
    cam15Pipelines.put("PL5", 5);
    cam15Pipelines.put("PL6", 6);
    cam15Pipelines.put("PL7", 7);
    cam15Pipelines.put("PL8", 8);
    cam15Pipelines.put("PL9", 9);

  }

  public static Map<String, Integer> cam16Pipelines;
  static {
    cam16Pipelines = new HashMap<>();
    cam16Pipelines.put("PL0", 0);
    cam16Pipelines.put("PL1", 1);
    cam16Pipelines.put("PL2", 2);
    cam16Pipelines.put("PL3", 3);
    cam16Pipelines.put("PL4", 4);
    cam16Pipelines.put("PL5", 5);
    cam16Pipelines.put("PL6", 6);
    cam16Pipelines.put("PL7", 7);
    cam16Pipelines.put("PL8", 8);
    cam16Pipelines.put("PL0", 9);

  }

  public LimelightVision() {

    cam15 = new LimeLight("limelight-fifteen");
  
    // cam15.setLEDMode(LedMode.kpipeLine);
    cam15.setCamMode(CamMode.kvision);
    cam15.setStream(StreamType.kStandard);
    cam15.setLEDMode(LedMode.kforceBlink);
  

    if (numCams > 1) {

      cam16 = new LimeLight("limelight-sixteen");

  
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("HeartBeat", cam15._heartBeatPeriod);
  }

}
