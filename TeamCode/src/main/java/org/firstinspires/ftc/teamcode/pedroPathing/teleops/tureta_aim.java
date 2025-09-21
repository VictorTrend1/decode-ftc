package org.firstinspires.ftc.teamcode.pedroPathing.teleops;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.DcMotor;

public class tureta_aim {
    private static final double gear_ratio = 7.0;
    private static final double tickuri_per_rev = 537.6;
    private static final double tickuri_per_degree = (tickuri_per_rev * gear_ratio) / 360.0;

    public void aiming(DcMotor motor, double X, double Y, Pose pozitie){

        double dx = X - pozitie.getX();
        double dy = Y - pozitie.getY();
        double unghitragere = Math.toDegrees(Math.atan2(dy,dx));

        int target_tureta = (int)(unghitragere * tickuri_per_degree);


        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(target_tureta);
        motor.setPower(0.5);
    }

}
