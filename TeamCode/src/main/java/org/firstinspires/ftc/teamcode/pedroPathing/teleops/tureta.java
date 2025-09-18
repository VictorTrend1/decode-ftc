//package org.firstinspires.ftc.teamcode.pedroPathing.teleops;
//
//import com.pedropathing.follower.Follower;
//import com.pedropathing.geometry.Pose;
//import org.firstinspires.ftc.teamcode.pedroPathing.motoare;
//
//public class tureta{
//    private Follower follower;
//    public void aiming (double targetx, double targety , double targetz){
//        Pose robotPose = follower.getPose();
//        double robotX = robotPose.getX();
//        double robotY = robotPose.getY();
//        double robotHeading = robotPose.getHeading();
//
//        double turretHeight = 12.0;
//
//        double dx = targetx - robotX;
//        double dy = targety - robotY;
//        double dz = targetz - turretHeight;
//
//        double absoluteYaw = Math.atan2(dy, dx);
//        double relativeYaw = (absoluteYaw - robotHeading);
//        double horizontalDistance = Math.hypot(dx, dy);
//        double pitchAngle = Math.atan2(dz, horizontalDistance);
//
//        // Limits
//        double YAW_MIN_ANGLE = -Math.PI / 2;
//        double YAW_MAX_ANGLE = Math.PI / 2;
//        double PITCH_MIN_ANGLE = Math.toRadians(-15);
//        double PITCH_MAX_ANGLE = Math.toRadians(45);
//
//        // Convert to servo positions
//        double yawServoPos = (Math.max(YAW_MIN_ANGLE, Math.min(YAW_MAX_ANGLE, relativeYaw)) - YAW_MIN_ANGLE)
//                / (YAW_MAX_ANGLE - YAW_MIN_ANGLE);
//
//        double pitchServoPos = (Math.max(PITCH_MIN_ANGLE, Math.min(PITCH_MAX_ANGLE, pitchAngle)) - PITCH_MIN_ANGLE)
//                / (PITCH_MAX_ANGLE - PITCH_MIN_ANGLE);
//
//    }
//
//}
