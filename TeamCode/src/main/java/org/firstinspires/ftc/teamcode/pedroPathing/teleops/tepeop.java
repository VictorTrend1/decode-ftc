package org.firstinspires.ftc.teamcode.pedroPathing.teleops;

import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Configurable
@TeleOp
public class tepeop extends OpMode {
    private Follower follower;
    public static Pose startingPose;
    private TelemetryManager telemetrie;
    @Override
    public void init() {
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(startingPose == null ? new Pose() : startingPose);
        follower.update();
        telemetrie = PanelsTelemetry.INSTANCE.getTelemetry();


    }
    @Override
    public void start(){
        follower.startTeleopDrive();
    }
    @Override
    public void loop(){
        follower.update();
        telemetrie.update();
        follower.setTeleOpDrive(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x,
                true
        );
        telemetrie.debug("pozitie: ", follower.getPose());
        telemetrie.debug("acceleratie: ", follower.getVelocity());
    }
}
