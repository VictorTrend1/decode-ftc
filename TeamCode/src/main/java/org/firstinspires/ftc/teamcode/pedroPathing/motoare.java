package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class motoare {
    public DcMotor tureta;

    public motoare(HardwareMap hardwareMap){
        tureta = hardwareMap.get(DcMotor.class,"tureta");
        tureta.setTargetPosition(0);
        tureta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        tureta.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
    public static void setpos(Servo servo, double pos){
        servo.setPosition(pos);
    }
}
