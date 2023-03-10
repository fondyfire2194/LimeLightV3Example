// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.oi;

import java.util.Map;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;

/** Add your docs here. */
public class ShuffleboardLL {

        private LimeLight m_ll;

        public ShuffleboardLL(LimeLight ll) {
                {

                        m_ll = ll;

                        String name = m_ll.getName();

                        ShuffleboardLayout col1_2 = Shuffleboard.getTab(name)
                                        .getLayout("A", BuiltInLayouts.kList).withPosition(0, 0)
                                        .withSize(2, 6).withProperties(Map.of("Label position", "LEFT"));

                        ShuffleboardLayout col3_4 = Shuffleboard.getTab(name)
                                        .getLayout("B", BuiltInLayouts.kList).withPosition(2, 0)
                                        .withSize(2, 6).withProperties(Map.of("Label position", "LEFT"));

                        ShuffleboardLayout col5_6 = Shuffleboard.getTab(name)
                                        .getLayout("C", BuiltInLayouts.kList).withPosition(4, 0)
                                        .withSize(6, 6).withProperties(Map.of("Label position", "LEFT"));

                        // columns 1 and 2

                        col1_2.addNumber(name + "HeartBeat", () -> m_ll.getHeartbeat());

                        col1_2.addBoolean(name + " hasTarget)", () -> m_ll.getIsTargetFound());

                        col1_2.addBoolean(name + " Connected", () -> m_ll.isConnected());

                        col1_2.addString(name + " Cam Mode ", () -> m_ll.getCamMode().toString());

                        col1_2.addString(name + " Led Mode", () -> m_ll.getLEDMode().toString());

                        col1_2.addString(name + " Stream Mode", () -> m_ll.getStream().toString());

                        col1_2.addNumber(name + " Pipeline", () -> m_ll.getPipeline());

                        col1_2.addNumber(name + " Latency ms", () -> round2dp(m_ll.getPipelineLatency()));

                        col1_2.addNumber(name + " Tag ID", () -> m_ll.getAprilTagID());

                        col1_2.addNumber(name + " Neur ID", () -> m_ll.getNeuralClassID());

                        // cols 3 and 4.

                        col3_4.addNumber(name + " BB Short", () -> round2dp(m_ll.getBoundingBoxShortestSide()));

                        col3_4.addNumber(name + " BB Long", () -> round2dp(m_ll.getBoundingBoxLongestSide()));

                        col3_4.addNumber(name + " BB Height", () -> round2dp(m_ll.getBoundingBoxHeight()));

                        col3_4.addNumber(name + " BB Width", () -> round2dp(m_ll.getBoundingBoxWidth()));

                        col3_4.addNumber(name + " BB Area ", () -> round2dp(m_ll.getTargetArea()));

                        col3_4.addNumber(name + " Deg Rot", () -> round2dp(m_ll.getdegRotationToTarget()));

                        col3_4.addNumber(name + " Deg Vert", () -> round2dp(m_ll.getdegVerticalToTarget()));

                        col3_4.addNumber(name + " Deg Skew", () -> round2dp(m_ll.getSkew_Rotation()));

                        // cols 5 and 6

                        col5_6.addString(name + " Rob Tran3d", () -> m_ll.getRobotTransform().toString());

                        col5_6.addString(name + " Cam Tran3d", () -> m_ll.getCamTran().toString());

                        col5_6.addDoubleArray(name + " HSV tc", () -> m_ll.getAveCrossHairColor());

                }

        }

        public double round2dp(double number) {

                number = Math.round(number * 100);
                number /= 100;
                return number;

        }

        public double round3dp(double number) {

                number = Math.round(number * 1000);
                number /= 1000;
                return number;

        }
}
