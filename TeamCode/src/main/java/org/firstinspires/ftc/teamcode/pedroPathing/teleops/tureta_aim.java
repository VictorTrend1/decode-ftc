package org.firstinspires.ftc.teamcode.pedroPathing.teleops;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.DcMotor;

public class tureta_aim {
    private static final double gear_ratio = 0.3;
    private static final double tickuri_per_rev = 537.6;
    private static final double tickuri_per_degree = (tickuri_per_rev * gear_ratio) / 360.0;
    private int adaos;

    public void aiming(DcMotor motor, double X, double Y, Pose pozitie){
        double dx = X - pozitie.getX();
        double dy = Y - pozitie.getY();
        double fieldAngleToTarget = Math.toDegrees(Math.atan2(dy,dx));
        double robotHeading_deg = Math.toDegrees(pozitie.getHeading());

        double desiredTurretAngleRelRobot_deg_raw = fieldAngleToTarget - robotHeading_deg;
        double desiredTurretAngleRelRobot_deg_normalized = ((desiredTurretAngleRelRobot_deg_raw % 360.0) + 540.0) % 360.0 - 180.0;


        int currentMotorPosition_ticks = motor.getCurrentPosition();

           double currentEffectiveAngle_deg = (double)(currentMotorPosition_ticks - adaos) / tickuri_per_degree;

       double angleDifference_deg = desiredTurretAngleRelRobot_deg_normalized - currentEffectiveAngle_deg;

        double shortestAngleDifference_deg = ((angleDifference_deg % 360.0) + 540.0) % 360.0 - 180.0;

         int ticksToMove = (int)(shortestAngleDifference_deg * tickuri_per_degree);

        int newTargetMotorPosition_ticks = currentMotorPosition_ticks + ticksToMove;

        motor.setTargetPosition(newTargetMotorPosition_ticks);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(0.8);
    }

    public void tureta_manual_plus(){
        adaos = adaos + 5;
    }

    public void tureta_manual_minus(){
        adaos = adaos - 5;
    }

    public void reset(){
        adaos = 0;
    }
}
