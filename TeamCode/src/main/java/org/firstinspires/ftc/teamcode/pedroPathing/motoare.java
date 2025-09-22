package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class motoare {
    public DcMotor tureta;

    public motoare(HardwareMap hardwareMap){
        tureta = hardwareMap.get(DcMotor.class,"tureta");
        tureta.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tureta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }
    public static void setpos(Servo servo, double pos){
        servo.setPosition(pos);
    }
}
