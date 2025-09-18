package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class motoare {
    public static Servo tureta;

    public motoare(HardwareMap hardwareMap){
        tureta = hardwareMap.get(Servo.class,"tureta");

    }
    public static void setpos(Servo servo, double pos){
        servo.setPosition(pos);
    }
}
